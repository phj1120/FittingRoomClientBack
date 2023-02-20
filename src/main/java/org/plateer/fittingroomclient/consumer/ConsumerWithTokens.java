package org.plateer.fittingroomclient.consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.plateer.fittingroomclient.common.security.dto.TokensDTO;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerWithTokens {
    private ConsumerDTO consumer;
    private TokensDTO tokens;
}
