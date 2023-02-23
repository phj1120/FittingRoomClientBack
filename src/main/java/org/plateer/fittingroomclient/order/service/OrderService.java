package org.plateer.fittingroomclient.order.service;

import org.plateer.fittingroomclient.order.order.OrderDTO;

public interface OrderService {
    Long insertModifyReservation(Long reNo);

    Long insertOrder(OrderDTO orderDTO);
}
