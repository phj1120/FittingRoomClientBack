package org.plateer.fittingroomclient.oauth.kakao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.security.JWTUtil;
import org.plateer.fittingroomclient.common.security.dto.TokensDTO;
import org.plateer.fittingroomclient.consumer.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.ConsumerWithTokens;
import org.plateer.fittingroomclient.consumer.mapper.ConsumerMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@RequiredArgsConstructor
public class KakaoService {

    @Value("${com.kakao.kauth.redirectUri}")
    private String redirectUri;
    @Value("${com.kakao.kauth.clientId}")
    private String clientId;
    @Value("${com.kakao.kauth.grantType}")
    private String grantType;

    private final ConsumerMapper consumerMapper;
    private final JWTUtil jwtUtil;

    public ConsumerWithTokens socialLogin(String code) {
        TokensDTO tokens = getTokens(code);
        String access = tokens.getAccess();
        KakaoUserInfoDTO userInfo = getUserInfo(access);
        String email = userInfo.getKakao_account().getEmail();

        ConsumerDTO consumerDTO = consumerMapper.getConsumerByEmail(email);
        TokensDTO tokensDTO = jwtUtil.generateTokens(email);

        // 처음 로그인 한 사용자
        if (consumerDTO == null) {
            consumerDTO = ConsumerDTO.builder()
                    .coEmail(email)
                    .coIsSignUp(false)
                    .coPassword(new BCryptPasswordEncoder().encode("defaultPassword"))
                    .build();
            consumerMapper.socialLogin(consumerDTO);
        }

        return new ConsumerWithTokens(consumerDTO, tokensDTO);
    }

    public TokensDTO getTokens(String code) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grantType);
        params.add("client_id", clientId);
        params.add("redirect_uri", redirectUri);
        params.add("code", code);

        HttpEntity request = new HttpEntity<>(params, headers);
        KaKaoTokensDResponseDTO kaKaoTokensDResponseDTO = restTemplate.postForObject("https://kauth.kakao.com/oauth/token", request, KaKaoTokensDResponseDTO.class);

        TokensDTO tokensDTO = new TokensDTO(kaKaoTokensDResponseDTO.getAccess_token(), kaKaoTokensDResponseDTO.getRefresh_token());
        return tokensDTO;
    }

    public KakaoUserInfoDTO getUserInfo(String token) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Authorization", "Bearer " + token);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("property_keys", "[\"kakao_account.email\"]");

        HttpEntity request = new HttpEntity<>(params, headers);
        KakaoUserInfoDTO kakaoUserInfoDTO = restTemplate.postForObject("https://kapi.kakao.com/v2/user/me", request, KakaoUserInfoDTO.class);

        return kakaoUserInfoDTO;
    }
}
