package org.plateer.fittingroomclient.order.mapper;

import org.plateer.fittingroomclient.order.order.OrderDTO;

import java.util.List;

public interface OrderMapper {

    Long insertModifyReservation(Long reNo);

    Long insertOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderByCaNo(Long caNo);
}
