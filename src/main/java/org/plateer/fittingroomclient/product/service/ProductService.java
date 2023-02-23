package org.plateer.fittingroomclient.product.service;


import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.product.dto.ProductDTO;
import org.plateer.fittingroomclient.product.dto.ProductPageRequestDTO;

public interface ProductService {
    PageResultDTO<ProductDTO> getSellerProductList(ProductPageRequestDTO productPageRequestDTO);
}
