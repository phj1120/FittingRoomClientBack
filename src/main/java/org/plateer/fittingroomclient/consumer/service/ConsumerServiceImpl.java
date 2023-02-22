package org.plateer.fittingroomclient.consumer.service;

import lombok.RequiredArgsConstructor;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.mapper.ConsumerMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 구매자 정보 조회 및 수정 Service
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

@Service
@RequiredArgsConstructor
@Transactional
public class ConsumerServiceImpl implements ConsumerService{

    private final ConsumerMapper consumerMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ConsumerDTO getConsumerInfo(Long coNo) {
        return consumerMapper.getConsumerInfo(coNo);
    }

    @Override
    public Long updateConsumerInfo(ConsumerDTO consumerDTO) {
        consumerDTO.setCoPassword(passwordEncoder.encode(consumerDTO.getCoPassword()));
        consumerMapper.updateConsumerInfo(consumerDTO);

        return consumerDTO.getCoNo();
    }
}
