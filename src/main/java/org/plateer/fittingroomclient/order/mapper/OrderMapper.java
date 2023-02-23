package org.plateer.fittingroomclient.order.mapper;

import org.plateer.fittingroomclient.order.order.OrderDTO;

public interface OrderMapper {

    Long insertModifyReservation(Long reNo);

    Long insertOrder(OrderDTO orderDTO);
}
