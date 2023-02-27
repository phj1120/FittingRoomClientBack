package org.plateer.fittingroomclient.cart.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.cart.service.CartService;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 장바구니 관련 기능 Controller
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

@RestController
@RequestMapping("api/consumer/cart")
@RequiredArgsConstructor
@Log4j2
public class CartController {

    private final CartService cartService;

    /**
     * 장바구니 생성
     **/
//    @PreAuthorize("hasRole('CONSUMER')")
    @PostMapping("")
    public ResultDTO<Long> insertCart(CartDTO cartDTO) {
        Long result = cartService.insertCart(cartDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 장바구니 조회
     **/
//    @PreAuthorize("hasRole('CONSUMER')")
    @GetMapping("/{coNo}")
    public ResultDTO<List<CartDTO>> getCartList(@PathVariable Long coNo) {

        List<CartDTO> result = cartService.getCartList(coNo);

        return ResultDTO.<List<CartDTO>>builder().data(result).build();
    }

    /**
     * 장바구니 삭제
     **/
//    @PreAuthorize("hasRole('CONSUMER')")
    @DeleteMapping("/{caNo}")
    public ResultDTO<Long> deleteCart(@PathVariable Long caNo) {

        Long result = cartService.deleteCart(caNo);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 장바구니 상품 추가
     **/
//    @PreAuthorize("hasRole('CONSUMER')")
    @PostMapping("/product")
    public ResultDTO<Long> insertCartProduct(CartProductDTO cartProductDTO) {

        Long result = cartService.insertCartProduct(cartProductDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 장바구니 상품 조회
     **/
    //@PreAuthorize("hasRole('CONSUMER')")
    @GetMapping("/products/{caNo}")
    public ResultDTO<List<CartProductDTO>> getCartProducts(@PathVariable Long caNo) {

        List<CartProductDTO> result = cartService.getCartProducts(caNo);

        return ResultDTO.<List<CartProductDTO>>builder().data(result).build();
    }

    /**
     * 장바구니 상품 삭제
     **/
//    @PreAuthorize("hasRole('CONSUMER')")
    @DeleteMapping("/product/{cpNo}")
    public ResultDTO<Long> deleteCartProduct(@PathVariable Long cpNo) {

        Long result = cartService.deleteCartProduct(cpNo);

        return ResultDTO.<Long>builder().data(result).build();
    }
    @PreAuthorize("hasRole('CONSUMER')")
    @GetMapping("/detail/{id}")
    public List<CartProductListDTO> getCartItemList(@PathVariable("id") Long caNo){



        return cartService.getCartItemList(caNo);
    }

}
