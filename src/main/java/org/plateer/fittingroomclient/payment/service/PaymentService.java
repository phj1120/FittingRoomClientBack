package org.plateer.fittingroomclient.payment.service;

import lombok.RequiredArgsConstructor;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.cart.service.CartService;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.service.ConsumerService;
import org.plateer.fittingroomclient.order.order.OrderDTO;
import org.plateer.fittingroomclient.order.service.OrderService;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveResponseDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentInfoDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.service.ReservationService;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.service.RoomService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final CartService cartService;
    private final RoomService roomService;
    private final ConsumerService consumerService;
    private final ReservationService reservationService;
    private final OrderService orderService;

    @Value("${com.kakao.authorizationKey}")
    private String kakaoAuthorizationKey;

    // 결제 승인
    @Transactional
    public void paymentApprove(PaymentApproveDTO paymentApproveDTO) {
        PaymentApproveResponseDTO paymentApproveResponseDTO = requestPaymentApprove(paymentApproveDTO);

        // order 테이블에 주문 정보 저장
        Long caNo = paymentApproveDTO.getPartner_order_id(); // 장바구니 아이디
        Long coNo = paymentApproveDTO.getPartner_user_id();  // 구매자 아이디

        OrderDTO orderDTO = new OrderDTO("에약중", caNo);
        Long orNo = orderService.insertOrder(orderDTO);

        // reservation 테이블에 예약 정보 저장
        LocalDate reDt = paymentApproveDTO.getRe_dt();
        Long reTime = paymentApproveDTO.getRe_time();
        Long payAmount = paymentApproveResponseDTO.getAmount().getTotal();

        // 장바구니 상품 상태 변경
        Long count = cartService.deleteCart(caNo);

        ReservationDTO reservationDTO = new ReservationDTO(reDt, reTime, payAmount, "결제완료", orNo);
        Long reNo = reservationService.insertReservation(reservationDTO);
    }

    private PaymentApproveResponseDTO requestPaymentApprove(PaymentApproveDTO paymentApproveDTO) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Authorization", "KakaoAK " + kakaoAuthorizationKey);

        // TODO 서버에 저장된 정보와 비교 하는 로직 추후 구현
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", paymentApproveDTO.getCid());
        params.add("tid", paymentApproveDTO.getTid());
        params.add("partner_order_id", String.valueOf(paymentApproveDTO.getPartner_order_id()));
        params.add("partner_user_id", String.valueOf(paymentApproveDTO.getPartner_user_id()));
        params.add("pg_token", paymentApproveDTO.getPg_token());

        HttpEntity request = new HttpEntity<>(params, headers);
        PaymentApproveResponseDTO paymentApproveResponseDTO = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/approve", request, PaymentApproveResponseDTO.class);
        return paymentApproveResponseDTO;
    }

    public PaymentInfoDTO getPaymentDetails(Long caNo) {
        // 주문 된 적이 있는 장바구니는 재 결제 불가능
        List<OrderDTO> orderDTOS = orderService.existOrder(caNo);
        if (orderDTOS.size() != 0) {
            throw new IllegalArgumentException("결제 불가능한 장바구니");
        }

        // 장바구니 정보 확인
        CartDTO cart = cartService.getCart(caNo);
        Long roNo = cart.getRoNo(); // 방 번호
        Long coNo = cart.getCoNo(); // 고객 번호

        List<CartProductDTO> cartProducts = cartService.getCartProducts(caNo);
        RoomDTO room = roomService.getRoom(roNo);
        ConsumerDTO consumer = consumerService.getConsumerInfo(coNo);

        PaymentInfoDTO paymentInfoDTO = new PaymentInfoDTO(consumer, room, cartProducts);

        return paymentInfoDTO;
    }
}
