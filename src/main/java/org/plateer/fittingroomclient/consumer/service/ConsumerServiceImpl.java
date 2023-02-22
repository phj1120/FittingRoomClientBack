package org.plateer.fittingroomclient.consumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.dto.request.ModifyConsumerRequestDTO;
import org.plateer.fittingroomclient.consumer.mapper.ConsumerMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 구매자 정보 조회 및 수정 Service
 * 작성자: 이수영, 박현준
 * 일시: 2023-02-21
 * 버전: v1
 **/
@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final ConsumerMapper consumerMapper;

    @Override
    public ConsumerDTO getConsumerInfo(Long coNo) {
        return consumerMapper.getConsumerInfo(coNo);
    }

    @Override
    public Long updateConsumerInfo(ConsumerDTO consumerDTO) {
        String encodePassword = new BCryptPasswordEncoder().encode(consumerDTO.getCoPassword());
        consumerDTO.setPasswordByEncoded(encodePassword);

        consumerMapper.updateConsumerInfo(consumerDTO);

        return consumerDTO.getCoNo();
    }

    // 소셜 로그인 후 추가 정보 입력
    @Override
    public long registerConsumer(ModifyConsumerRequestDTO modifyConsumerRequestDTO) {
        ConsumerDTO consumerDTO = modifyConsumerRequestDTO.convert(new BCryptPasswordEncoder());

        long count = consumerMapper.registerConsumer(consumerDTO);
        if (count == 0) {
            throw new IllegalArgumentException("수정된 사용자 없음");
        }

        log.info("[Register Consumer]: {}", consumerDTO.getCoNo());
        return consumerDTO.getCoNo();
    }

    @Override
    public ConsumerDTO getConsumerByEmail(String username) {
        ConsumerDTO consumerByEmail = consumerMapper.getConsumerByEmail(username);
        if (consumerByEmail == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자");
        }

        return consumerByEmail;
    }
}
