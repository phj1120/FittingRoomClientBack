package org.plateer.fittingroomclient.payment.service;

import org.plateer.fittingroomclient.common.security.dto.TokensDTO;
import org.plateer.fittingroomclient.oauth.kakao.dto.KaKaoTokensDResponseDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveDTO;
import org.plateer.fittingroomclient.payment.dto.PaymentApproveResponseDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {
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
}
