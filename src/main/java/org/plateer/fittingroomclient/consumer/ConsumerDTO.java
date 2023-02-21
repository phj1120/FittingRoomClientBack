package org.plateer.fittingroomclient.consumer;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsumerDTO {
    private Long coNo;
    private String coName;
    private String coNickname;
    private String coGender;
    private String coBirth;
    private String coEmail;
    private String coPassword;
    private boolean coIsSignUp = false;
    private String coPhone;
    private String coAddress;
    private String coDetailAddress;
    private String coPostNumber; // TODO 추후 추가 될 것 같아 미리 추가.
    private boolean coStatus;
    private LocalDateTime coCreate_dt;
    private LocalDateTime co_modify_dt;

    public ConsumerDTO(Long coNo, String coEmail, String coName, String coNickname,
                       String coPhone, String coBirth, String coGender,
                       String coAddress, String coDetailAddress, String coPostNumber) {
        this.coNo = coNo;
        this.coEmail = coEmail;
        this.coName = coName;
        this.coNickname = coNickname;
        this.coPhone = coPhone;
        this.coBirth = coBirth;
        this.coGender = coGender;
        this.coAddress = coAddress;
        this.coDetailAddress = coDetailAddress;
        this.coPostNumber = coPostNumber;

        this.coIsSignUp = true;
    }
}
