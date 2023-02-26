package org.plateer.fittingroomclient.product.service;


import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.product.dto.ProductCartDTO;
import org.plateer.fittingroomclient.product.dto.ProductDTO;
import org.plateer.fittingroomclient.product.dto.ProductDetailDTO;
import org.plateer.fittingroomclient.product.dto.ProductPageRequestDTO;

import java.util.List;

public interface ProductService {
    PageResultDTO<ProductDTO> getSellerProductList(ProductPageRequestDTO productPageRequestDTO);

    List<ProductDetailDTO> getProduct(ProductDetailDTO productDetailDTO);

    List<ProductDetailDTO> getProductOption(ProductDetailDTO productDetailDTO);

    void insertProductCart(ProductCartDTO productCartDTO);
}
