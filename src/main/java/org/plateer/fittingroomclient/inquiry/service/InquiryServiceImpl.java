package org.plateer.fittingroomclient.inquiry.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;
import org.plateer.fittingroomclient.inquiry.mapper.InquiryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService{

    private final InquiryMapper inquiryMapper;

    @Override
    public InquiryDTO getInquiry(Long inNo) {

        return inquiryMapper.getInquiry(inNo);
    }
}
