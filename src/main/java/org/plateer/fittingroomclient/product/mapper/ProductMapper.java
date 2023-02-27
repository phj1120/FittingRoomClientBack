package org.plateer.fittingroomclient.product.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroomclient.product.dto.ProductDTO;
import org.plateer.fittingroomclient.product.dto.ProductDetailDTO;
import org.plateer.fittingroomclient.product.dto.ProductPageRequestDTO;

import java.util.List;


@Mapper
public interface ProductMapper {
    // 특정 장소에 판매 상품 전체 총 개수 ( 장소 클릭 후 들어갔을 때 리스트 메뉴 )
    int getSellerProductCount( ProductPageRequestDTO productPageRequestDTO );

    // 특정 장소에 판매 상품 전체 리스트 ( 장소 클릭 후 들어갔을 때 리스트 메뉴 )
    List<ProductDTO> getSellerProductList( ProductPageRequestDTO productPageRequestDTO );

    // 특정 상품 클릭 시 Detail 페이지
    List<ProductDetailDTO> getProduct(ProductDetailDTO productDetailDTO);

    // 특정 상품의 옵션 리스트
    List<ProductDetailDTO> getProductOption(ProductDetailDTO productDetailDTO);
}
