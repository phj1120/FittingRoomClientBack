package org.plateer.fittingroomclient.oauth.kakao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KakaoAccountDTO {
    private String has_email;
    private String email_needs_agreement;
    private String is_email_valid;
    private String is_email_verified;
    private String email;
}
