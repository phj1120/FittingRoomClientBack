package org.plateer.fittingroomclient.consumer.service;

import lombok.RequiredArgsConstructor;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.mapper.ConsumerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ConsumerServiceImpl implements ConsumerService{

    private final ConsumerMapper consumerMapper;

    @Override
    public ConsumerDTO getConsumerInfo(Long coNo) {
        return consumerMapper.getConsumerInfo(coNo);
    }

    @Override
    public Long updateConsumerInfo(ConsumerDTO consumerDTO) {
        consumerMapper.updateConsumerInfo(consumerDTO);

        return consumerDTO.getCoNo();
    }
}
