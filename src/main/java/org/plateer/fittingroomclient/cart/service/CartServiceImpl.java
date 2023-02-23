package org.plateer.fittingroomclient.cart.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.cart.mapper.CartMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 장바구니 관련 기능 Service
 * 작성자: 이수영
 * 일시: 2023-02-21
 * 버전: v1
 **/

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;

    @Override
    public Long insertCart(CartDTO cartDTO) {
        cartMapper.insertCart(cartDTO);
        return cartDTO.getRoNo();
    }

    @Override
    public List<CartDTO> getCartList(Long coNo) {
        return cartMapper.getCartList(coNo);
    }

    @Override
    public Long deleteCart(Long caNo) {
        cartMapper.deleteCart(caNo);
        return caNo;
    }

    @Override
    public Long insertCartProduct(CartProductDTO cartProductDTO) {
        cartMapper.insertCartProduct(cartProductDTO);
        return cartProductDTO.getCaNo();
    }

    @Override
    public List<CartProductDTO> getCartProducts(Long caNo) {
        return cartMapper.getCartProducts(caNo);
    }

    @Override
    public Long deleteCartProduct(Long cpNo) {
        cartMapper.deleteCartProduct(cpNo);
        return cpNo;
    }

    @Override
    public CartDTO getCart(Long caNo) {
        CartDTO cartDTO = cartMapper.getCart(caNo);
        if (cartDTO == null) {
            throw new IllegalArgumentException("존재하지 않는 장바구니");
        }

        return cartDTO;
    }
}
