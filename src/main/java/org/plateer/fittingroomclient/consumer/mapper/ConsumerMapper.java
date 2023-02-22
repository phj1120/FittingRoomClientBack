package org.plateer.fittingroomclient.consumer.mapper;

import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;

/**
 * Consumer 정보 조회 및 수정 Mapper
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

public interface ConsumerMapper {

    ConsumerDTO getConsumerInfo(Long coNo);

    int updateConsumerInfo(ConsumerDTO consumerDTO);
}
