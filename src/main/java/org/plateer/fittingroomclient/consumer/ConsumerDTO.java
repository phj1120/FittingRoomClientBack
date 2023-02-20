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
    private boolean coStatus;
    private LocalDateTime coCreate_dt;
    private LocalDateTime co_modify_dt;

    public ConsumerDTO(String coEmail, String coName, String coNickname, String coGender, String coBirth,
                       String coPhone, String coAddress, String coDetailAddress) {
        this.coEmail = coEmail;
        this.coName = coName;
        this.coNickname = coNickname;
        this.coGender = coGender;
        this.coBirth = coBirth;
        this.coIsSignUp = true;
        this.coPhone = coPhone;
        this.coAddress = coAddress;
        this.coDetailAddress = coDetailAddress;
    }
}
