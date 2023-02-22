package org.plateer.fittingroomclient.inquiry.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.plateer.fittingroomclient.common.dto.PageRequestDTO;
import org.plateer.fittingroomclient.inquiry.dto.enums.InquiryListOrder;
import org.plateer.fittingroomclient.inquiry.dto.enums.SortType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class InquiryPageSearchRequestDTO extends PageRequestDTO {

    private String keyword;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDt = LocalDate.now();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDt = LocalDate.now().minusYears(1L); // 1년 전부터 지금이 기본

    // 상품번호, 카테고리, 브랜드, 상품명, 이미지, 가격, 등록일, 수정일, 상태
    private InquiryListOrder sort;

    private SortType sortType;

    public InquiryPageSearchRequestDTO(int page, int size, String keyword,
                                       LocalDate startDt, LocalDate endDt) {
        super(page, size);
        this.keyword = keyword;
        this.startDt = startDt;
        this.endDt = endDt;
    }

    public InquiryPageSearchRequestDTO(int page, int size, String keyword) {
        super(page, size);
        this.keyword = keyword;
        this.startDt = LocalDate.now().minusYears(1L);
        this.endDt = LocalDate.now();
    }

}
