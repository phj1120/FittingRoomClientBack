package org.plateer.fittingroomclient.product.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroomclient.product.dto.ProductDTO;

import java.util.List;


@Mapper
public interface ProductMapper {
    // 특정 장소에 판매 상품 전체 리스트 ( 장소 클릭 후 들어갔을 때 리스트 메뉴 )
    List<ProductDTO> getRoomProductList( ProductDTO productDTO );
}
