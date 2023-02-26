package org.plateer.fittingroomclient.cart.mapper;

import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;

import java.util.List;

/**
 * 장바구니 관련 기능 Mapper
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

public interface CartMapper {

    List<CartDTO> getCartList(Long coNo);

    int insertCart(CartDTO cartDTO);

    int deleteCart(Long caNo);

    List<CartProductDTO> getCartProducts(Long caNo);

    int insertCartProduct(CartProductDTO cartProductDTO);

    Long deleteCartProduct(Long cpNo);
    
    List<CartProductListDTO> getCartItemList(Long caNo);

    CartDTO getCart(Long caNo);

    Long modifyCartItem(Long caNo);
}
