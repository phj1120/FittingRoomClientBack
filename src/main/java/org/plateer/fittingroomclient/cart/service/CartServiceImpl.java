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

        return cartMapper.insertCart(cartDTO);
    }
    @Override
    public List<CartDTO> getCartList(Long coNo) {

        return cartMapper.getCartList(coNo);
    }

    @Override
    public Long deleteCart(Long caNo) {
        return cartMapper.deleteCart(caNo);
    }

    @Override
    public Long insertCartProduct(CartProductDTO cartProductDTO) {

        return cartMapper.insertCartProduct(cartProductDTO);
    }

    @Override
    public List<CartProductDTO> getCartProducts(Long caNo) {

        return cartMapper.getCartProducts(caNo);
    }
    @Override
    public Long deleteCartProduct(Long cpNo) {

        return cartMapper.deleteCartProduct(cpNo);
    }
}
