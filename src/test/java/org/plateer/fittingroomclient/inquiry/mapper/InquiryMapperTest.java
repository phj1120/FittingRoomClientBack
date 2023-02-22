package org.plateer.fittingroomclient.inquiry.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryPageSearchRequestDTO;
import org.plateer.fittingroomclient.inquiry.dto.enums.InquiryStatus;
import org.plateer.fittingroomclient.inquiry.dto.enums.InquiryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Q&A 관련 기능 Mapper 테스트
 * 작성자: 이수영
 * 일시: 2023-02-22
 * 버전: v1
 **/

@SpringBootTest
@Transactional
@Log4j2
class InquiryMapperTest {

    @Autowired
    InquiryMapper inquiryMapper;

    @Test
    void getInquiryList() {
        InquiryPageSearchRequestDTO inquiryPageSearchRequestDTO
                = new InquiryPageSearchRequestDTO(1, 10, "문의");
        List<InquiryDTO> result = inquiryMapper.getInquiryList(1L, inquiryPageSearchRequestDTO);
        log.info(result);
    }

    @Test
    void getInquiryListCount() {
        InquiryPageSearchRequestDTO inquiryPageSearchRequestDTO
                = new InquiryPageSearchRequestDTO(1, 10, "문의");
        int result = inquiryMapper.getInquiryListCount(1L, inquiryPageSearchRequestDTO);
        log.info(result);
    }

    @Test
    void insertInquiry() {
        InquiryDTO inquiryDTO = InquiryDTO.builder()
                .inTitle("문의제목")
                .inContent("문의내용")
                .inStatus(InquiryStatus.WAITING)
                .inType(InquiryType.PRODUCT)
                .pmNo(1L)
                .coNo(1L)
                .seNo(null)
                .build();
        int result = inquiryMapper.insertInquiry(inquiryDTO);
        log.info(result);
    }

    @Test
    void getInquiry() {
        InquiryDTO result = inquiryMapper.getInquiry(1L);
        log.info(result);
    }

    @Test
    void updateInquiry() {
        InquiryDTO inquiryDTO = InquiryDTO.builder()
                .inNo(12L)
                .inTitle("문의제목수정")
                .inContent("문의내용수정")
                .build();
        int result = inquiryMapper.updateInquiry(inquiryDTO);
        log.info(result);
    }

    @Test
    void deleteInquiry() {
        int result = inquiryMapper.deleteInquiry(3L);
        log.info(result);
    }
}