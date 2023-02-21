package org.plateer.fittingroomclient.common.common.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TokensDTO {
    private String access;
    private String refresh;
}
