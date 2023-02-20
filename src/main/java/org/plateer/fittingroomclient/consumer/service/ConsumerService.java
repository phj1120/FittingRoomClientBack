package org.plateer.fittingroomclient.consumer.service;

import lombok.RequiredArgsConstructor;
import org.plateer.fittingroomclient.consumer.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.mapper.ConsumerMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final ConsumerMapper consumerMapper;
    public long modifyConsumer(ConsumerDTO consumerDTO) {
        long count = consumerMapper.modifyConsumer(consumerDTO);

        return consumerDTO.getCoNo();
    }
}
