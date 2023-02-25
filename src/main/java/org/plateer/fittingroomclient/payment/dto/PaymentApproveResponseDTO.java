package org.plateer.fittingroomclient.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentApproveResponseDTO {
    private String tid; // 결제 고유 번호
    private String cid; // 가맹점 코드
    private String partner_order_id; // 가맹점 주문 번호
    private String partner_user_id; // 가맹점 회원 id
    private String payment_method_type; // 결제 수단
    private KakaoPayAmount amount; // 결제 금액 정보
    private String item_name; // 상품 이름
    private String quantity; // 상품 수량
    private String created_at; // 결제 준비 요청 시각
    private String approved_at; // 결제 승인 시각
}
