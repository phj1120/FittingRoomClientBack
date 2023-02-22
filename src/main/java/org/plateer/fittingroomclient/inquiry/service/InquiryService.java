package org.plateer.fittingroomclient.inquiry.service;

import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryPageSearchRequestDTO;

/**
 * Q&A 관련 기능 Service Interface
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

public interface InquiryService {

    Long insertInquiry(InquiryDTO inquiryDTO);

    PageResultDTO<InquiryDTO> getInquiryList(Long coNo, InquiryPageSearchRequestDTO inquiryPageSearchRequestDTO);

    InquiryDTO getInquiry(Long inNo);

    Long deleteInquiry(Long inNo);

    Long updateInquiry(InquiryDTO inquiryDTO);

}
