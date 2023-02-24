package org.plateer.fittingroomclient.order.service;

import org.plateer.fittingroomclient.order.order.OrderDTO;

import java.util.List;

public interface OrderService {
    Long insertModifyReservation(Long reNo);

    Long insertOrder(OrderDTO orderDTO);

    List<OrderDTO> existOrder(Long caNo);
}
