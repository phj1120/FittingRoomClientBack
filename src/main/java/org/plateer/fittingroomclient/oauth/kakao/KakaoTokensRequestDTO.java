package org.plateer.fittingroomclient.oauth.kakao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoTokensRequestDTO {
    private String grant_type;
    private String client_id;
    private String redirect_uri;
    private String code;
}
