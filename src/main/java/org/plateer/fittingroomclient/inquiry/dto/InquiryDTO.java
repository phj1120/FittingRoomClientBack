package org.plateer.fittingroomclient.inquiry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.fittingroomclient.inquiry.dto.enums.InquiryStatus;
import org.plateer.fittingroomclient.inquiry.dto.enums.InquiryType;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InquiryDTO {

    private Long inNo; // 문의 번호

    private String inTitle; // 문의 제목

    private String inContent; // 문의 내용

    private InquiryStatus inStatus; // 문의 상태

    private InquiryType inType; // 문의 타입

    private LocalDateTime inCreateDt; // 문의 등록일

    private LocalDateTime inModifyDt; // 문의 수정일

    private Long pmNo; // 장소제공자 번호

    private Long seNo; // 판매자 번호

    private Long coNo; // 구매자 번호

    private String name; // 장소 or 상호 명

    public InquiryDTO(String inTitle, String inContent) {
        this.inTitle = inTitle;
        this.inContent = inContent;
    }
}
