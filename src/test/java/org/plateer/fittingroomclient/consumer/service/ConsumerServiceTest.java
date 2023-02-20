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
                "hyeonj1998@naver.com",
                "coName", "coNickName", "Man", "1998-11-20", "010-1234-5678", "hi", "hi");

        long l = consumerService.modifyConsumer(consumerDTO);

        System.out.println(l);
    }
}