package org.plateer.fittingroomclient.product.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO {
    // 장소, 상품, 판매자, 카테고리, 파일, 옵션 번호
    private Long roNo;
    private Long prNo;
    private Long seNo;
    private Long prcNo;
    private Long prfNo;
    private Long spNo;

    // 상품, 파일, 옵션 상태
    private String prStatus;
    private String prfStatus;
    private String spStatus;

    // 상품정보 ( 브랜드, 상품명, 가격 )
    private String prBrand;
    private String prName;
    private Long prPrice;

    // 상품옵션정보 ( 사이즈 )
    private String spSize;

    // 카테고리정보
    private String prcPathName;
    
    // 파일정보 ( uuid, 사용구분 )
    private String prfUuid;
    private String prfType;
}