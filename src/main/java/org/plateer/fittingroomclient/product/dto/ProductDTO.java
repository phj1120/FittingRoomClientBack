package org.plateer.fittingroomclient.product.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    // 장소제공자, 판매자, 상품 번호
    private Long pmNo;
    private Long seNo;
    private Long prNo;

    // 판매자, 상품 상태
    private String seStatus;
    private String prStatus;

    // 판매자정보 ( 상호명, 담당자 )
    private String seName;
    private String seManager;

    // 상품정보 ( 브랜드, 상품명, 대표이미지 )
    private String prBrand;
    private String prName;
    private String prfUuid;
}