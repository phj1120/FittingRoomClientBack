package org.plateer.fittingroomclient.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.order.mapper.OrderMapper;
import org.plateer.fittingroomclient.order.order.OrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Override
    public Long insertModifyReservation(Long reNo) {
        return orderMapper.insertModifyReservation(reNo);
    }

    @Override
    public Long insertOrder(OrderDTO orderDTO) {
        Long count = orderMapper.insertOrder(orderDTO);
        if (count != 1) {
            throw new IllegalArgumentException("추가된 Order 없음");
        }

        return orderDTO.getOrNo();
    }

    @Override
    public List<OrderDTO> existOrder(Long caNo) {
        List<OrderDTO> orderDTOs = orderMapper.getOrderByCaNo(caNo);

        return orderDTOs;
    }
}
