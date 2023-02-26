package org.plateer.fittingroomclient.order.mapper;


import org.plateer.fittingroomclient.order.order.OrderDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationNoDTO;
import java.util.List;
public interface OrderMapper {

    Long insertModifyReservation(ReservationNoDTO reservationNoDTO);

    Long insertCancleReservation(ReservationNoDTO reservationNoDTO);

    List<OrderDTO> getOrderByCaNo(Long caNo);

    Long insertOrder(OrderDTO orderDTO);
}


