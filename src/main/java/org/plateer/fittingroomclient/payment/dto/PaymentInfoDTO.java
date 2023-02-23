package org.plateer.fittingroomclient.payment.dto;

import lombok.*;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.room.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfoDTO {
    // 구매자 정보
    private Long coNo; // 구매자 번호
    private String coName; // 이름
    private String coNickname; // 닉네임
    private String coGender; // 성별
    private String coBirth; // 생년월일
    private String coEmail; // 이메일
    private String coPhone; // 전화번호

    // 장소 정보
    private String roName; // 이름
    private String roAddress; // 주소
    private String roDetailAddress; // 상세 주소
    private String roPostCode; // 우편 번호

    // 상품 정보
    List<CartProductDTO> products = new ArrayList<>();

    // 금액 정보
    private Long payAmount;

    public PaymentInfoDTO(ConsumerDTO consumerDTO, RoomDTO roomDTO, List<CartProductDTO> products) {
        this.coNo = consumerDTO.getCoNo();
        this.coName = consumerDTO.getCoName();
        this.coNickname = consumerDTO.getCoNickname();
        this.coGender = consumerDTO.getCoGender();
        this.coBirth = consumerDTO.getCoBirth();
        this.coEmail = consumerDTO.getCoEmail();
        this.coPhone = consumerDTO.getCoPhone();
        this.roName = roomDTO.getRoName();
        this.roAddress = roomDTO.getRoAddress();
        this.roDetailAddress = roomDTO.getRoDetailAddress();
        this.roPostCode = roomDTO.getRoPostCode();
        this.products = products;

        this.payAmount = (long) (10000 + (products.size() * 1000));
    }
}
