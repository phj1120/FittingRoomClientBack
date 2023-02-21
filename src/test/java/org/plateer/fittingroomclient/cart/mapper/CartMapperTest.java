package org.plateer.fittingroomclient.cart.mapper;


import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class CartMapperTest {
    @Autowired
    CartMapper cartMapper;

    @Test
    void insertCart() {
        IntStream.rangeClosed(1, 1).forEach(i -> {
            CartDTO cartDTO = CartDTO.builder()
                    .roNo(1L)
                    .coNo(1L)
                    .build();
            cartMapper.insertCart(cartDTO);
        });
    }

    @Test
    void insertCartProduct() {
        IntStream.rangeClosed(1, 1).forEach(i -> {
            CartProductDTO cartProductDTO = CartProductDTO.builder()
                    .cpStatus(true)
                    .caNo(4L)
                    .spNo(1L)
                    .build();
            cartMapper.insertCartProduct(cartProductDTO);
        });
    }
}
