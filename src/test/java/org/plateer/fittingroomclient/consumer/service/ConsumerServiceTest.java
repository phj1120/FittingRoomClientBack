package org.plateer.fittingroomclient.consumer.service;

import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.consumer.ConsumerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConsumerServiceTest {

    @Autowired
    private ConsumerService consumerService;

    @Test
    void modify() {
        ConsumerDTO consumerDTO = new ConsumerDTO(
                14L, "hyeonj1998@naver.com", "coName", "coNickname",
                "010-1234-5678", "1998-11-20", "coGender",
                "coAddress", "coDetailAddress", "1234");

        long l = consumerService.modifyConsumer(consumerDTO);

        System.out.println(l);
    }
}