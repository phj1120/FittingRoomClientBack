package org.plateer.fittingroomclient.product.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartDTO {
    // 장소, 장바구니리, 상품, 사용자 번호
    private Long roNo;
    private Long caNo;
    private Long prNo;
    private Long coNo;
    
    // 상품 옵션 리스트
    private Long[] spList;

    // 장바구니 상품 상태
    private String cpStatus;
}