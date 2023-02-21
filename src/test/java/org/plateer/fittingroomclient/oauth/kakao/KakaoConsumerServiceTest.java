package org.plateer.fittingroomclient.oauth.kakao;

import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.common.security.dto.TokensDTO;
import org.plateer.fittingroomclient.consumer.mapper.ConsumerMapper;
import org.plateer.fittingroomclient.oauth.kakao.dto.KakaoUserInfoDTO;
import org.plateer.fittingroomclient.oauth.kakao.service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KakaoConsumerServiceTest {

    @Autowired
    private KakaoService kakaoService;

    @Autowired
    ConsumerMapper consumerMapper;

    @Test
    void getTokens() {
        TokensDTO tokens = kakaoService.getTokens("Rcvb6QyrRJawlpoiNEGRDFmsRV0Rk7NcERx4HEKoCpl_UxaJiOqtpkYYTHUKiiAjxEjUBwopyV8AAAGGak2wVA");

        System.out.println(tokens);
    }

    @Test
    void getUserInfo() {
        KakaoUserInfoDTO kakaoUserInfoDTO = kakaoService.getUserInfo("KkOByVjvg7SfxkXwflTBcg4b2WMHV9_PsViwFgv4CiolTwAAAYZqTedw");

        System.out.println(kakaoUserInfoDTO);

    }

    @Test
    void getUserInfoByToken() {
        TokensDTO tokens = kakaoService.getTokens("fD-Ihyf51-Qse3YQzgPiU0hGIvBE-O2ZYmENenBMgDfvfCnRBWMA01MDC6HlufhDCaJOxworDR4AAAGGakydtg");

        KakaoUserInfoDTO userInfo = kakaoService.getUserInfo(tokens.getAccess());

        System.out.println(userInfo);
    }
}
