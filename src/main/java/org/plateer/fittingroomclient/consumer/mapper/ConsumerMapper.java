package org.plateer.fittingroomclient.consumer.mapper;

import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;

public interface ConsumerMapper {

    ConsumerDTO getConsumerInfo(Long coNo);

    int updateConsumerInfo(ConsumerDTO consumerDTO);
}
