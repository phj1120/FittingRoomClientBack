package org.plateer.fittingroomclient.product.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.product.dto.ProductDTO;
import org.plateer.fittingroomclient.product.dto.ProductPageRequestDTO;
import org.plateer.fittingroomclient.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Log4j2
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;


    @Override
    public PageResultDTO<ProductDTO> getSellerProductList(ProductPageRequestDTO productPageRequestDTO) {
        List<ProductDTO> dtoList = productMapper.getSellerProductList(productPageRequestDTO);
        int total = productMapper.getSellerProductCount(productPageRequestDTO);

        return PageResultDTO.<ProductDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(productPageRequestDTO).build();
    }
}
