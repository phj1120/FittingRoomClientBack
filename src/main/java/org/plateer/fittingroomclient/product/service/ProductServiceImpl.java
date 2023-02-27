package org.plateer.fittingroomclient.product.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.cart.mapper.CartMapper;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.product.dto.ProductCartDTO;
import org.plateer.fittingroomclient.product.dto.ProductDTO;
import org.plateer.fittingroomclient.product.dto.ProductDetailDTO;
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
    private final CartMapper cartMapper;


    @Override
    public PageResultDTO<ProductDTO> getSellerProductList(ProductPageRequestDTO productPageRequestDTO) {
        List<ProductDTO> dtoList = productMapper.getSellerProductList(productPageRequestDTO);
        int total = productMapper.getSellerProductCount(productPageRequestDTO);

        return PageResultDTO.<ProductDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(productPageRequestDTO).build();
    }

    @Override
    public List<ProductDetailDTO> getProduct(ProductDetailDTO productDetailDTO) {
        return productMapper.getProduct(productDetailDTO);
    }

    @Override
    public List<ProductDetailDTO> getProductOption(ProductDetailDTO productDetailDTO) {
        return productMapper.getProductOption(productDetailDTO);
    }

    @Override
    public void insertProductCart(ProductCartDTO productCartDTO) {
        CartDTO cartDTO = CartDTO.builder().roNo(productCartDTO.getRoNo()).coNo(productCartDTO.getCoNo()).build();
        if ( cartMapper.checkCart(cartDTO) == 0 ) {
            cartMapper.insertCart(cartDTO);
        } else {
            cartDTO.setCaNo(cartMapper.getCartInfo(cartDTO));
        }

        CartProductDTO cartProductDTO = CartProductDTO.builder().cpStatus(true).caNo(cartDTO.getCaNo()).spList(List.of(productCartDTO.getSpList())).build();
        cartMapper.insertProductCartList(cartProductDTO, cartProductDTO.getSpList());
    }
}
