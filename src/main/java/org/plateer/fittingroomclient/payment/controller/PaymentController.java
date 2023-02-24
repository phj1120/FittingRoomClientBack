package org.plateer.fittingroomclient.payment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.payment.dto.AbleReservationDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveResponseDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentInfoDTO;
import org.plateer.fittingroomclient.payment.service.PaymentService;
import org.plateer.fittingroomclient.reservation.service.ReservationService;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final ReservationService reservationService;

    // TODO 본인의 장바구니만 접근 가능하도록 수정
    @GetMapping("/api/payment/{caNo}")
    public ResultDTO<PaymentInfoDTO> getPaymentDetails(@PathVariable Long caNo) {
        PaymentInfoDTO paymentDetails = paymentService.getPaymentDetails(caNo);

        return ResultDTO.<PaymentInfoDTO>builder()
                .data(paymentDetails)
                .build();
    }

    // TODO 본인의 장바구니만 결제 가능하도록 수정
    @PostMapping("/api/payment/approve")
    public ResultDTO<Boolean> paymentApprove(@RequestBody PaymentApproveDTO paymentApproveDTO) {
        paymentService.paymentApprove(paymentApproveDTO);

        return ResultDTO.<Boolean>builder()
                .data(true)
                .build();
    }

    @GetMapping("/api/payment/ableReservation")
    public void ableReservation(AbleReservationDTO reservationRequest) {
        reservationService.getAbleReservation(reservationRequest); // TODO 기능 구현 미완료
    }
}
