package org.plateer.fittingroomclient.consumer.mapper;

import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;

/**
 * Consumer 정보 조회 및 수정 Mapper
 * 작성자: 이수영, 박현준
 * 일시: 2023-02-21
 * 버전: v1
 **/
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

    long registerConsumer(ConsumerDTO consumerDTO);
    
    ConsumerDTO getConsumerInfo(Long coNo);

    int updateConsumerInfo(ConsumerDTO consumerDTO);
}
