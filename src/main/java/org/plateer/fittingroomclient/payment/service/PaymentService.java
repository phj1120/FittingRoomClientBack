package org.plateer.fittingroomclient.payment.service;

import lombok.RequiredArgsConstructor;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.cart.service.CartService;
import org.plateer.fittingroomclient.common.security.dto.TokensDTO;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.service.ConsumerService;
import org.plateer.fittingroomclient.oauth.kakao.dto.KaKaoTokensDResponseDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveResponseDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentInfoDTO;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.service.RoomService;
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

    public PaymentApproveResponseDTO paymentApprove(PaymentApproveDTO paymentApproveDTO) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", paymentApproveDTO.getCid());
        params.add("tid", paymentApproveDTO.getTid());
        params.add("partner_order_id", paymentApproveDTO.getPartner_order_id());
        params.add("partner_user_id", paymentApproveDTO.getPartner_user_id());
        params.add("pg_token", paymentApproveDTO.getPg_token());

        HttpEntity request = new HttpEntity<>(params, headers);
        PaymentApproveResponseDTO paymentApproveResponseDTO = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/approve", request, PaymentApproveResponseDTO.class);

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
