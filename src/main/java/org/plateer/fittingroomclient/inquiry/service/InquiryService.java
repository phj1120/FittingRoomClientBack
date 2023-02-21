package org.plateer.fittingroomclient.inquiry.service;

import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryPageSearchRequestDTO;

public interface InquiryService {

    Long insertInquiry(InquiryDTO inquiryDTO);

    PageResultDTO<InquiryDTO> getInquiryList(Long coNo, InquiryPageSearchRequestDTO inquiryPageSearchRequestDTO);

    InquiryDTO getInquiry(Long inNo);

    Long deleteInquiry(Long inNo);

    Long updateInquiry(InquiryDTO inquiryDTO);

}
