package org.plateer.fittingroomclient.inquiry.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;
import org.plateer.fittingroomclient.inquiry.service.InquiryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/consumer")
@RequiredArgsConstructor
@Log4j2
public class InquiryController {

    private final InquiryService inquiryService;

    @GetMapping("/inquiry/{inNo}")
    public InquiryDTO getInquiry(@PathVariable Long inNo) {

        return inquiryService.getInquiry(inNo);
    }
}
