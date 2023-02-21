package org.plateer.fittingroomclient.consumer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.common.security.dto.CustomUserDetail;
import org.plateer.fittingroomclient.consumer.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.ModifyConsumerRequestDTO;
import org.plateer.fittingroomclient.consumer.service.ConsumerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/api/consumer")
@RequiredArgsConstructor
public class ConsumerController {
    private final ConsumerService consumerService;

    @PreAuthorize("hasRole('consumer')")  // TODO 본인의 정보만 수정 가능하도록 수정 필요
    @PutMapping
    public ResultDTO<Long> modifyConsumerDTO(
            @AuthenticationPrincipal CustomUserDetail customUserDetail,
            @RequestBody @Valid ModifyConsumerRequestDTO modifyConsumerRequestDTO) {
        ConsumerDTO consumerDTO = modifyConsumerRequestDTO.convert();
        long coNo = consumerService.modifyConsumer(consumerDTO);

        return ResultDTO.<Long>builder().data(coNo).build();
    }
}
