package org.plateer.fittingroomclient.cart.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductDTO;
import org.plateer.fittingroomclient.cart.mapper.CartMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;

    @Override
    public Long insertCart(CartDTO cartDTO) {
        cartMapper.insertCart(cartDTO);
        return cartDTO.getCaNo();
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
}
