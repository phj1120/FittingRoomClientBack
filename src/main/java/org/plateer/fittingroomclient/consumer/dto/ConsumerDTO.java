package org.plateer.fittingroomclient.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerDTO {

    private Long coNo; // 구매자 번호

    private String coName; // 이름

    private String coNickname; // 닉네임

    private String coGender; // 성별

    private String coBirth; // 생년월일

    private String coPassword; // 비밀번호

    private String coEmail; // 이메일

    private String coPhone; // 전화번호

    private String coAddress; // 주소

    private String coDetailAddress; // 상세주소

    private Boolean coStatus; // 상태

    private LocalDateTime coCreateDt; // 가입일

    private LocalDateTime coModifyDt; // 수정일

    private Boolean coIsSignUp; // 소셜로그인여부

}
