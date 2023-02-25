package org.plateer.fittingroomclient.reservation.service;

import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.payment.dto.TimeOfReservation;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.getReservationListDTO;

import java.util.List;

public interface ReservationService {


    List<getReservationListDTO> getReservationList(Long coNo);

    List<CartProductListDTO> getReservationDetail(Long caNo);

    Long modifyReservationDetail(ReservationDTO reservationDTO);

    // 예약 가능한 시간대 조회
    List<Long> getAbleTimeOfReservation(TimeOfReservation timeOfReservation);


    Long insertReservation(ReservationDTO reservationDTO);
}
