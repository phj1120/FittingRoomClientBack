package org.plateer.fittingroomclient.cart.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.cart.service.CartService;
import org.plateer.fittingroomclient.common.common.dto.ResultDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/consumer/cart")
@RequiredArgsConstructor
@Log4j2
public class CartController {

    private final CartService cartService;

    /**
     * 장바구니 생성
     **/
    @PostMapping("")
    public ResultDTO<Long> insertCart(CartDTO cartDTO) {

        Long result = cartService.insertCart(cartDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 장바구니 조회
     **/
    @GetMapping("/{coNo}")
    public ResultDTO<List<CartDTO>> getCartList(@PathVariable Long coNo) {

        List<CartDTO> result = cartService.getCartList(coNo);

        return ResultDTO.<List<CartDTO>>builder().data(result).build();
    }

    /**
     * 장바구니 삭제
     **/
    @DeleteMapping("/{caNo}")
    public ResultDTO<Long> deleteCart(@PathVariable Long caNo) {

        Long result = cartService.deleteCart(caNo);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 장바구니 상품 추가
     **/
    @PostMapping("/product")
    public ResultDTO<Long> insertCartProduct(CartProductDTO cartProductDTO) {

        Long result = cartService.insertCartProduct(cartProductDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 장바구니 상품 조회
     **/
    @GetMapping("/products/{caNo}")
    public ResultDTO<List<CartProductDTO>> getCartProducts(@PathVariable Long caNo) {

        List<CartProductDTO> result = cartService.getCartProducts(caNo);

        return ResultDTO.<List<CartProductDTO>>builder().data(result).build();
    }

    /**
     * 장바구니 상품 삭제
     **/
    @DeleteMapping("/product/{cpNo}")
    public ResultDTO<Long> deleteCartProduct(@PathVariable Long cpNo) {

        Long result = cartService.deleteCartProduct(cpNo);

        return ResultDTO.<Long>builder().data(result).build();
    }
}
