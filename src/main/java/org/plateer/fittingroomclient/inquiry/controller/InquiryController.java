package org.plateer.fittingroomclient.inquiry.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.PageRequestDTO;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.inquiry.dto.InquiryDTO;
import org.plateer.fittingroomclient.inquiry.dto.enums.InquiryStatus;
import org.plateer.fittingroomclient.inquiry.service.InquiryService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('CONSUMER')")
    @PostMapping("/inquiry")
    public ResultDTO<Boolean> insertInquiry(InquiryDTO inquiryDTO) {
        Boolean result = inquiryService.insertInquiry(inquiryDTO);

        return ResultDTO.<Boolean>builder().data(result).build();
    }

    /**
     * 문의 목록 조회
     **/
    @PreAuthorize("hasRole('CONSUMER')")
    @GetMapping("/inquiry/list")
    public PageResultDTO<InquiryDTO> getInquiryList(Long coNo, PageRequestDTO pageRequestDTO) {
        coNo = 1L;
        PageResultDTO<InquiryDTO> result = inquiryService.getInquiryList(coNo, pageRequestDTO);

        return result;
    }

    /**
     * 문의 상세 조회
     **/
    @PreAuthorize("hasRole('CONSUMER')")
    @GetMapping("/inquiry/{inNo}")
    public ResultDTO<InquiryDTO> getInquiryList(@PathVariable Long inNo) {
        InquiryDTO result = inquiryService.getInquiry(inNo);

        return ResultDTO.<InquiryDTO>builder().data(result).build();
    }

    /**
     * 문의 수정
     **/
    @PreAuthorize("hasRole('CONSUMER')")
    @PutMapping("/inquiry/{inNo}")
    public ResultDTO<Long> updateInquiry(InquiryDTO inquiryDTO) {
        if (inquiryDTO.getInStatus() != InquiryStatus.WAITING) {
            return ResultDTO.<Long>builder().error("이미 처리된 Q&A 입니다.").build();
        }
        Long result = inquiryService.updateInquiry(inquiryDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 문의 삭제
     **/
    @PreAuthorize("hasRole('CONSUMER')")
    @DeleteMapping("/inquiry/{inNo}")
    public ResultDTO<Long> deleteInquiry(@PathVariable Long inNo) {
        Long result = inquiryService.deleteInquiry(inNo);

        return ResultDTO.<Long>builder().data(result).build();
    }
}
