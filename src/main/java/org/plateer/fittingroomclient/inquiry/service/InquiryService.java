package org.plateer.fittingroomclient.inquiry.service;

import org.plateer.fittingroomclient.common.dto.PageRequestDTO;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;

/**
 * Q&A 관련 기능 Service Interface
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

public interface InquiryService {

    Boolean insertInquiry(InquiryDTO inquiryDTO);

    PageResultDTO<InquiryDTO> getInquiryList(Long coNo, PageRequestDTO pageRequestDTO);

    InquiryDTO getInquiry(Long inNo);

    Long deleteInquiry(Long inNo);

    Long updateInquiry(InquiryDTO inquiryDTO);

}
