package org.plateer.fittingroomclient.payment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.common.security.dto.CustomUserDetail;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentInfoDTO;
import org.plateer.fittingroomclient.payment.dto.TimeOfReservation;
import org.plateer.fittingroomclient.payment.service.PaymentService;
import org.plateer.fittingroomclient.reservation.service.ReservationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final ReservationService reservationService;

    @PreAuthorize("#customUserDetail != null && @paymentChecker.hasPermission(#customUserDetail.userNo, #caNo)")
    @GetMapping("/api/payment/{caNo}")
    public ResultDTO<PaymentInfoDTO> getPaymentDetails(
            @AuthenticationPrincipal CustomUserDetail customUserDetail,
            @PathVariable Long caNo) {
        PaymentInfoDTO paymentDetails = paymentService.getPaymentDetails(caNo);

        return ResultDTO.<PaymentInfoDTO>builder()
                .data(paymentDetails)
                .build();
    }

    @PreAuthorize("#customUserDetail != null && @paymentChecker.hasPermission(#customUserDetail.userNo, #paymentApproveDTO.partner_order_id)")
    @PostMapping("/api/payment/approve")
    public ResultDTO<Boolean> paymentApprove(
            @AuthenticationPrincipal CustomUserDetail customUserDetail,
            @RequestBody PaymentApproveDTO paymentApproveDTO) {
        paymentService.paymentApprove(paymentApproveDTO);

        return ResultDTO.<Boolean>builder()
                .data(true)
                .build();
    }

    @PreAuthorize("hasRole('CONSUMER')")
    @GetMapping("/api/payment/ableReservation")
    public ResultDTO<List> ableReservation(TimeOfReservation reservationRequest) {
        List<Long> ableTimeOfReservation = reservationService.getAbleTimeOfReservation(reservationRequest);

        return ResultDTO.<List>builder().data(ableTimeOfReservation).build();
    }
}
