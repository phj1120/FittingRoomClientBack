package org.plateer.fittingroomclient.payment.controller;


import lombok.RequiredArgsConstructor;
import org.plateer.fittingroomclient.payment.dto.PaymentInfoDTO;
import org.plateer.fittingroomclient.payment.service.PaymentService;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 접근한 사용자의 권한 확인
 * 작성자: 박현준
 * 일시: 2023-02-26
 * 버전: v1
 **/
@Component
@RequiredArgsConstructor
public class PaymentChecker {

    private final PaymentService paymentService;

    public Boolean hasPermission(Long coNo, Long caNo) {
        PaymentInfoDTO paymentDetails = paymentService.getPaymentDetails(caNo);
        Long paymentCoNo = paymentDetails.getCoNo();

        return Objects.equals(paymentCoNo, coNo);
    }

}
