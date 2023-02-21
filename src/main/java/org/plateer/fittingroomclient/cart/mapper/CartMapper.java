package org.plateer.fittingroomclient.cart.mapper;

import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;

import java.util.List;

public interface CartMapper {

    List<CartDTO> getCartList(Long coNo);

    Long insertCart(CartDTO cartDTO);

    Long deleteCart(Long caNo);

    List<CartProductDTO> getCartProducts(Long caNo);

    Long insertCartProduct(CartProductDTO cartProductDTO);

    Long deleteCartProduct(Long cpNo);
}
