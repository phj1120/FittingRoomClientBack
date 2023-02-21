package org.plateer.fittingroomclient.consumer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.service.ConsumerService;
import org.springframework.web.bind.annotation.*;

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
        Long result = consumerService.updateConsumerInfo(consumerDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }
}
