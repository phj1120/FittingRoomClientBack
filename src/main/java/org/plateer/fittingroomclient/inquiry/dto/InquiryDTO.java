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

    private String coName; // 구매자 이름

    private String seName; // 판매자 이름

    private String pmName; // 장소제공자 이름

    /**
     * 문의 등록
     **/
    public InquiryDTO(String inTitle, String inContent, InquiryStatus inStatus, InquiryType inType,
                      String coName, String seName, String pmName) {
        this.inTitle = inTitle;
        this.inContent = inContent;
        this.inStatus = inStatus;
        this.inType = inType;
        this.coName = coName;
        this.seName = seName;
        this.pmName = pmName;
    }

    /**
     * 문의 조회
     **/
    public InquiryDTO(String inTitle, String inContent, InquiryStatus inStatus, InquiryType inType,
                      LocalDateTime inCreateDt, LocalDateTime inModifyDt, String coName, String seName, String pmName) {
        this.inTitle = inTitle;
        this.inContent = inContent;
        this.inStatus = inStatus;
        this.inType = inType;
        this.inCreateDt = inCreateDt;
        this.inModifyDt = inModifyDt;
        this.coName = coName;
        this.seName = seName;
        this.pmName = pmName;
    }
}
