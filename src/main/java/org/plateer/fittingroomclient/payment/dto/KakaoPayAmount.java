package org.plateer.fittingroomclient.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPayAmount {
    private Long total;
    private Long tax_free;
    private Long vat;
    private Long point;
    private Long discount;
    private Long green_deposit;
}
