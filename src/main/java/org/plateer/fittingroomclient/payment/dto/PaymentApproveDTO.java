package org.plateer.fittingroomclient.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentApproveDTO {
    private String cid;
    private String tid;
    private Long partner_order_id;
    private Long partner_user_id;
    private String pg_token;
    private LocalDate re_dt; // 예약일자
    private Long re_time; // 예약일시
}
