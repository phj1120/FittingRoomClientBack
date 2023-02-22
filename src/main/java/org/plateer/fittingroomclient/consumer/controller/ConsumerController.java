package org.plateer.fittingroomclient.consumer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.common.security.dto.CustomUserDetail;
import org.plateer.fittingroomclient.consumer.dto.request.ModifyConsumerRequestDTO;
import org.plateer.fittingroomclient.consumer.service.ConsumerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.service.ConsumerService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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
        Long result = consumerService.updateConsumerInfo(consumerDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }
    
    //    @PreAuthorize("hasRole('consumer')")  // TODO 본인의 정보만 수정 가능하도록 수정 필요
    @PutMapping("/register")
    public ResultDTO<Long> registerConsumer(
            @AuthenticationPrincipal CustomUserDetail customUserDetail,
            @RequestBody @Valid ModifyConsumerRequestDTO modifyConsumerRequestDTO) {
        long coNo = consumerService.registerConsumer(modifyConsumerRequestDTO);

        return ResultDTO.<Long>builder().data(coNo).build();
    }
}
