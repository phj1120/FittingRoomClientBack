package org.plateer.fittingroomclient.consumer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.service.ConsumerService;
import org.springframework.web.bind.annotation.*;

/**
 * 구매자 정보 조회 및 수정 Controller
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

@RestController
@RequestMapping("api/consumer")
@RequiredArgsConstructor
@Log4j2
public class ConsumerController {

    private final ConsumerService consumerService;

    @GetMapping("/{coNo}")
    public ResultDTO<ConsumerDTO> getConsumerInfo(@PathVariable Long coNo) {
        ConsumerDTO result = consumerService.getConsumerInfo(coNo);

        return ResultDTO.<ConsumerDTO>builder().data(result).build();
    }

    @PutMapping("/{coNo}")
    public ResultDTO<Long> updateConsumerInfo(ConsumerDTO consumerDTO) {
        if (consumerDTO.getCoPassword().equals(consumerDTO.getCheckPassword())) {
            log.info("비밀번호 확인");
        } else {
            log.info("비밀번호 불일치");
            return ResultDTO.<Long>builder().error("비밀번호 불일치").build();
        }
        Long result = consumerService.updateConsumerInfo(consumerDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }
}
