package org.plateer.fittingroomclient.consumer.mapper;

import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;

public interface ConsumerMapper {
    // 소셜 로그인
    int socialLogin(ConsumerDTO consumerDTO);

    // 회원 가입
    ConsumerDTO signUp(ConsumerDTO consumerDTO);

    // 정보 조회
    ConsumerDTO getConsumerByCoNo(Long coNo);

    // 정보 조회
    ConsumerDTO getConsumerByEmail(String email);

    // 로그인
    ConsumerDTO signIn(ConsumerDTO consumerDTO);

    long modifyConsumer(ConsumerDTO consumerDTO);
}
