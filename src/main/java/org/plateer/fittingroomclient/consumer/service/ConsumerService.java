package org.plateer.fittingroomclient.consumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.dto.request.ModifyConsumerRequestDTO;
import org.plateer.fittingroomclient.consumer.mapper.ConsumerMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final ConsumerMapper consumerMapper;

    // 소셜 로그인 후 추가 정보 입력
    public long registerConsumer(ModifyConsumerRequestDTO modifyConsumerRequestDTO) {
        ConsumerDTO consumerDTO = modifyConsumerRequestDTO.convert(new BCryptPasswordEncoder());

        long count = consumerMapper.registerConsumer(consumerDTO);
        if (count == 0) {
            throw new IllegalArgumentException("수정된 사용자 없음");
        }

        log.info("[Register Consumer]: {}", consumerDTO.getCoNo());
        return consumerDTO.getCoNo();
    }

    public ConsumerDTO getConsumerByEmail(String username) {
        ConsumerDTO consumerByEmail = consumerMapper.getConsumerByEmail(username);
        if (consumerByEmail == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자");
        }

        return consumerByEmail;
    }
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
