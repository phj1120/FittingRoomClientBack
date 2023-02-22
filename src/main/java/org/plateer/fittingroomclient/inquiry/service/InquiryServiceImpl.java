package org.plateer.fittingroomclient.inquiry.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryPageSearchRequestDTO;
import org.plateer.fittingroomclient.inquiry.dto.enums.InquiryType;
import org.plateer.fittingroomclient.inquiry.mapper.InquiryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Q&A 관련 기능 Service
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService{

    private final InquiryMapper inquiryMapper;

    @Override
    public Boolean insertInquiry(InquiryDTO inquiryDTO) {
        if(inquiryDTO.getSeNo() != null) {
            inquiryDTO.setInType(InquiryType.PRODUCT);
        } else {
            inquiryDTO.setInType(InquiryType.PLACE);
        }
        inquiryMapper.insertInquiry(inquiryDTO);
        return true;
    }

    @Override
    public PageResultDTO<InquiryDTO> getInquiryList(Long coNo, InquiryPageSearchRequestDTO inquiryPageSearchRequestDTO) {
        List<InquiryDTO> inquiryList = inquiryMapper.getInquiryList(coNo, inquiryPageSearchRequestDTO);
        int total = inquiryMapper.getInquiryListCount(coNo, inquiryPageSearchRequestDTO);
        PageResultDTO<InquiryDTO> result = PageResultDTO.<InquiryDTO>withAll().pageRequestDTO(inquiryPageSearchRequestDTO)
                .dtoList(inquiryList)
                .total(total)
                .build();
        return result;
    }

    @Override
    public InquiryDTO getInquiry(Long inNo) {
        return inquiryMapper.getInquiry(inNo);
    }

    @Override
    public Long deleteInquiry(Long inNo) {
        inquiryMapper.deleteInquiry(inNo);

        return inNo;
    }

    @Override
    public Long updateInquiry(InquiryDTO inquiryDTO) {
        inquiryMapper.updateInquiry(inquiryDTO);

        return inquiryDTO.getInNo();
    }

}
