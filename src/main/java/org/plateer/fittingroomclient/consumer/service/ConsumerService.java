package org.plateer.fittingroomclient.consumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.mapper.ConsumerMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ConsumerService {
    private final ConsumerMapper consumerMapper;

    // 사용자 정보 수정(소셜 로그인 후 추가 정보 입력)
    public long modifyConsumer(ConsumerDTO consumerDTO) {
        long count = consumerMapper.modifyConsumer(consumerDTO);
        if (count == 0) {
            throw new IllegalArgumentException("수정된 사용자 없음");
        }

        log.info("[Modify Consumer]: {}", consumerDTO.getCoNo());
        return consumerDTO.getCoNo();
    }
}
