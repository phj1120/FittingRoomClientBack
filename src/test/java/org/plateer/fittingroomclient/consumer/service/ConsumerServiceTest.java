package org.plateer.fittingroomclient.consumer.service;

import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.dto.request.ModifyConsumerRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServiceTest {

    @Autowired
    private ConsumerService consumerService;

    @Test
    void modify() {
        ModifyConsumerRequestDTO modifyConsumerRequestDTO = new ModifyConsumerRequestDTO(
                17L, "hyeonj1998@naver.com", "password",
                "coName", "coNickname",
                "010-1234-5678", "1998-11-20", "coGender",
                "coAddress", "coDetailAddress", "1234");
        long l = consumerService.registerConsumer(modifyConsumerRequestDTO);

        System.out.println(l);
    }
}