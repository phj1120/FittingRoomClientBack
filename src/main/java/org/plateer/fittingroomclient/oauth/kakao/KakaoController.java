package org.plateer.fittingroomclient.oauth.kakao;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.common.security.dto.CustomUserDetail;
import org.plateer.fittingroomclient.consumer.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.ConsumerWithTokens;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;

    @PostMapping("/api/oauth/kakao/{code}")
    public ResultDTO<ConsumerWithTokens> socialLogin(@PathVariable String code) {
        ConsumerWithTokens consumerWithTokens = kakaoService.socialLogin(code);

        return ResultDTO.<ConsumerWithTokens>builder()
                .data(consumerWithTokens)
                .build();
    }
}
