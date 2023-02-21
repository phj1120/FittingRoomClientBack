package org.plateer.fittingroomclient.consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyConsumerRequestDTO {
    @NotNull
    private Long coNo;

    @Email
    private String coEmail;

    @NotBlank
    private String coName;

    @NotBlank
    private String coNickname;

    @NotBlank
    private String coPhone;

    @NotBlank
    private String coBirth;

    @NotBlank
    private String coGender;

    @NotBlank
    private String coAddress;

    @NotBlank
    private String coDetailAddress;

    @NotBlank
    private String coPostNumber;

    public ConsumerDTO convert() {
        return new ConsumerDTO(coNo, coEmail, coName, coNickname, coPhone, coBirth, coGender, coAddress, coDetailAddress, coPostNumber);
    }

}
