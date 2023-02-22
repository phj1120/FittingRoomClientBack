package org.plateer.fittingroomclient.cart.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 장바구니 관련 기능 Mapper 테스트
 * 작성자: 이수영
 * 일시: 2023-02-22
 * 버전: v1
 **/

@SpringBootTest
@Transactional
@Log4j2
class CartMapperTest {

    @Autowired
    CartMapper cartMapper;

    @Test
    void getCartList() {
        List<CartDTO> result = cartMapper.getCartList(1L);
        log.info(result);
    }

    @Test
    void insertCart() {
        CartDTO cartDTO = CartDTO.builder()
                .roNo(7L)
                .coNo(1L)
                .build();
        int result = cartMapper.insertCart(cartDTO);
        log.info(result);
    }

    @Test
    void deleteCart() {
        int result = cartMapper.deleteCart(18L);
        log.info(result);
    }

    @Test
    void getCartProducts() {
        List<CartProductDTO> result = cartMapper.getCartProducts(4L);
        log.info(result);
    }

    @Test
    void insertCartProduct() {
        CartProductDTO cartProductDTO = CartProductDTO.builder()
                .caNo(4L)
                .spNo(3L)
                .cpStatus(true)
                .build();
        int result = cartMapper.insertCartProduct(cartProductDTO);
        log.info(result);
    }

    @Test
    void deleteCartProduct() {
        long result = cartMapper.deleteCartProduct(14L);
        log.info(result);
    }
}