package org.plateer.fittingroomclient.order.mapper;

import org.plateer.fittingroomclient.reservation.dto.ReservationNoDTO;

public interface OrderMapper {

    Long insertModifyReservation(ReservationNoDTO reservationNoDTO);

    Long insertCancleReservation(ReservationNoDTO reservationNoDTO);
}
