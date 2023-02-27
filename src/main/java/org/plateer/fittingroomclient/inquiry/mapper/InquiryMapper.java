package org.plateer.fittingroomclient.inquiry.mapper;

import org.plateer.fittingroomclient.common.dto.PageRequestDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;

import java.util.List;

/**
 * Q&A 관련 기능 Mapper
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/
public interface InquiryMapper {

    List<InquiryDTO> getInquiryList(Long coNo, PageRequestDTO pageRequestDTO);

    int getInquiryListCount(Long coNo, PageRequestDTO pageRequestDTO);

    int insertInquiry(InquiryDTO inquiryDTO);

    InquiryDTO getInquiry(Long inNo);

    int updateInquiry(InquiryDTO inquiryDTO);

    int deleteInquiry(Long inNo);

}
