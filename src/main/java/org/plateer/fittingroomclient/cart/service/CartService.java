package org.plateer.fittingroomclient.cart.service;

import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;

import java.util.List;

/**
 * 장바구니 관련 기능 Service Interface
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

public interface CartService {

    Long insertCart(CartDTO cartDTO);

    List<CartDTO> getCartList(Long coNo);


    Long deleteCart(Long caNo);

    Long insertCartProduct(CartProductDTO cartProductDTO);

    List<CartProductDTO> getCartProducts(Long caNo);

    Long deleteCartProduct(Long cpNo);

    CartDTO getCart(Long caNo);
}
