package org.plateer.fittingroomclient.payment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveResponseDTO;
import org.plateer.fittingroomclient.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/api/paymenrt/approve")
    public void paymentApprove(@RequestBody PaymentApproveDTO paymentApproveDTO) {
        PaymentApproveResponseDTO paymentApproveResponseDTO = paymentService.paymentApprove(paymentApproveDTO);

        System.out.println(paymentApproveResponseDTO);
    }
}
