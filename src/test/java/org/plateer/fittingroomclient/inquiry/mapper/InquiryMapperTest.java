package org.plateer.fittingroomclient.inquiry.mapper;


import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;
import org.plateer.fittingroomclient.inquiry.dto.enums.InquiryStatus;
import org.plateer.fittingroomclient.inquiry.dto.enums.InquiryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class InquiryMapperTest {
    @Autowired
    InquiryMapper inquiryMapper;

//    @Test
//    void insertInquiry() {
//        IntStream.rangeClosed(1, 1).forEach(i -> {
//            InquiryDTO inquiryDTO = InquiryDTO.builder()
//                    .inTitle("문의합니다.")
//                    .inContent("가입")
//                    .inStatus(InquiryStatus.WAITING)
//                    .inType(InquiryType.PRODUCT)
//                    .coNo(1L)
//                    .reNo(1L)
//                    .build();
//            inquiryMapper.insertInquiry(inquiryDTO);
//        });
//    }
}
