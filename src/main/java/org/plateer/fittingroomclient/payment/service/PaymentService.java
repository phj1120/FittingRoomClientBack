package org.plateer.fittingroomclient.payment.service;

import lombok.RequiredArgsConstructor;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.cart.service.CartService;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.service.ConsumerService;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveResponseDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentInfoDTO;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.service.RoomService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final CartService cartService;
    private final RoomService roomService;
    private final ConsumerService consumerService;


    @Value("${com.kakao.authorizationKey}")
    private String kakaoAuthorizationKey;

    public PaymentApproveResponseDTO paymentApprove(PaymentApproveDTO paymentApproveDTO) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Authorization", "KakaoAK " + kakaoAuthorizationKey);

        // TODO 서버에 저장된 정보와 비교 하는 로직 추후 구현
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", paymentApproveDTO.getCid());
        params.add("tid", paymentApproveDTO.getTid());
        params.add("partner_order_id", paymentApproveDTO.getPartner_order_id());
        params.add("partner_user_id", paymentApproveDTO.getPartner_user_id());
        params.add("pg_token", paymentApproveDTO.getPg_token());

        HttpEntity request = new HttpEntity<>(params, headers);
        PaymentApproveResponseDTO paymentApproveResponseDTO = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/approve", request, PaymentApproveResponseDTO.class);

        // TODO DB에 저장 하는 로직 구현


        return paymentApproveResponseDTO;
    }

    public PaymentInfoDTO getPaymentDetails(Long caNo) {
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
