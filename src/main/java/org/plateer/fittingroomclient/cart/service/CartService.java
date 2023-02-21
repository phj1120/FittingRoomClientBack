package org.plateer.fittingroomclient.cart.service;

import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;

import java.util.List;

public interface CartService {

    Long insertCart(CartDTO cartDTO);

    List<CartDTO> getCartList(Long coNo);


    Long deleteCart(Long caNo);

    Long insertCartProduct(CartProductDTO cartProductDTO);

    List<CartProductDTO> getCartProducts(Long caNo);

    Long deleteCartProduct(Long cpNo);
}
