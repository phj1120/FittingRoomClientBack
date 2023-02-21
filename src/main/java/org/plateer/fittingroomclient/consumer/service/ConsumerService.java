package org.plateer.fittingroomclient.consumer.service;

import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;

public interface ConsumerService {

    ConsumerDTO getConsumerInfo(Long coNo);

    Long updateConsumerInfo(ConsumerDTO consumerDTO);
}
