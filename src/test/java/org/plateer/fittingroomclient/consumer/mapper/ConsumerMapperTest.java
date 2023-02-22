package org.plateer.fittingroomclient.consumer.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 구매자 정보 조회 및 수정 Mapper 테스트
 * 작성자: 이수영
 * 일시: 2023-02-22
 * 버전: v1
 **/

@SpringBootTest
@Transactional
@Log4j2
class ConsumerMapperTest {

    @Autowired
    ConsumerMapper consumerMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void getConsumerInfo() {
        ConsumerDTO result = consumerMapper.getConsumerInfo(1L);
        log.info(result);
    }

    @Test
    void updateConsumerInfo() {
        ConsumerDTO consumerDTO = ConsumerDTO.builder()
                .coNo(1L)
                .coNickname("닉네임")
                .coGender("성별")
                .coBirth("123456")
                .coPassword(passwordEncoder.encode("1234"))
                .checkPassword(passwordEncoder.encode("1234"))
                .coPhone("010-1234-5678")
                .coAddress("서울특별시")
                .coDetailAddress("강남구")
                .build();
        int result = consumerMapper.updateConsumerInfo(consumerDTO);
        log.info(result);
    }
}