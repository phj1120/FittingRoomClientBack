package org.plateer.fittingroomclient.consumer.service;

import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;

/**
 * 구매자 정보 조회 및 수정 Service Interface
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

public interface ConsumerService {

    ConsumerDTO getConsumerInfo(Long coNo);

    Long updateConsumerInfo(ConsumerDTO consumerDTO);
}
