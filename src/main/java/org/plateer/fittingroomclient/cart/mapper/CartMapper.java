package org.plateer.fittingroomclient.cart.mapper;

import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;

import java.util.List;

public interface CartMapper {

    List<CartDTO> getCartList(Long coNo);

    int insertCart(CartDTO cartDTO);

    int deleteCart(Long caNo);

    List<CartProductDTO> getCartProducts(Long caNo);

    int insertCartProduct(CartProductDTO cartProductDTO);

    int deleteCartProduct(Long cpNo);
}
