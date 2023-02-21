package org.plateer.fittingroomclient.inquiry.mapper;

import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;

import java.util.List;

/**
 * Q&A 관리 Mapper
 * 작성자: 이수영
 * 일시: 2023-02-20
 * 버전: v1
 **/
public interface InquiryMapper {

    List<InquiryDTO> getInquiryList(Long coNo);

    InquiryDTO getInquiry(Long inNo);

    int insertInquiry(InquiryDTO inquiryDTO);

    int updateInquiry(InquiryDTO inquiryDTO);

    int deleteInquiry(Long inNo);

}
