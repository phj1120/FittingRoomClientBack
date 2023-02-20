package org.plateer.fittingroomclient.oauth.kakao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KakaoUserInfoDTO {
    private Long id;
    private LocalDateTime connected_at;
    private KakaoAccountDTO kakao_account;
}
