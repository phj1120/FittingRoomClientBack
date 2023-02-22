package org.plateer.fittingroomclient.inquiry.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryPageSearchRequestDTO;
import org.plateer.fittingroomclient.inquiry.service.InquiryService;
import org.springframework.web.bind.annotation.*;

/**
 * Q&A 관련 기능 Controller
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

@RestController
@RequestMapping("api/consumer")
@RequiredArgsConstructor
@Log4j2
public class InquiryController {

    private final InquiryService inquiryService;

    /**
     * 문의 등록
     **/
    //    @PreAuthorize("hasRole('CONSUMER')")
    @PostMapping("/inquiry")
    public ResultDTO<Long> insertInquiry(InquiryDTO inquiryDTO) {
        Long result = inquiryService.insertInquiry(inquiryDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 문의 목록 조회
     **/
//    @PreAuthorize("hasRole('CONSUMER')")
    @GetMapping("/inquiry/list/{coNo}")
    public PageResultDTO<InquiryDTO> getInquiryList(@PathVariable Long coNo, InquiryPageSearchRequestDTO inquiryPageSearchRequestDTO) {
        PageResultDTO<InquiryDTO> result = inquiryService.getInquiryList(coNo, inquiryPageSearchRequestDTO);

        return result;
    }

    /**
     * 문의 상세 조회
     **/
    //    @PreAuthorize("hasRole('CONSUMER')")
    @GetMapping("/inquiry/{inNo}")
    public ResultDTO<InquiryDTO> getInquiryList(@PathVariable Long inNo) {
        InquiryDTO result = inquiryService.getInquiry(inNo);

        return ResultDTO.<InquiryDTO>builder().data(result).build();
    }

    /**
     * 문의 수정
     **/
    //    @PreAuthorize("hasRole('CONSUMER')")
    @PutMapping("/inquiry/{inNo}")
    public ResultDTO<Long> updateInquiry(InquiryDTO inquiryDTO) {
        Long result = inquiryService.updateInquiry(inquiryDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 문의 삭제
     **/
    //    @PreAuthorize("hasRole('CONSUMER')")
    @DeleteMapping("/inquiry/{inNo}")
    public ResultDTO<Long> deleteInquiry(@PathVariable Long inNo) {
        Long result = inquiryService.deleteInquiry(inNo);

        return ResultDTO.<Long>builder().data(result).build();
    }
}
