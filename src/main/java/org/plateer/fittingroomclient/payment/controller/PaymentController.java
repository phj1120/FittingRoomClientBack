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

    @PostMapping("/api/payment/approve")
    public ResultDTO<PaymentApproveResponseDTO> paymentApprove(@RequestBody PaymentApproveDTO paymentApproveDTO) {
        PaymentApproveResponseDTO paymentApproveResponseDTO = paymentService.paymentApprove(paymentApproveDTO);

        return ResultDTO.<PaymentApproveResponseDTO>builder()
                .data(paymentApproveResponseDTO)
                .build();
    }

    @GetMapping("/api/payment/{caNo}")
    public ResultDTO<PaymentInfoDTO> getPaymentDetails(@PathVariable Long caNo) {
        PaymentInfoDTO paymentDetails = paymentService.getPaymentDetails(caNo);

        return ResultDTO.<PaymentInfoDTO>builder()
                .data(paymentDetails)
                .build();
    }

    @GetMapping("/api/payment/ableReservation")
    public void ableReservation(AbleReservationDTO reservationRequest) {
        reservationService.getAbleReservation(reservationRequest); // TODO 기능 구현 미완료
    }
}
