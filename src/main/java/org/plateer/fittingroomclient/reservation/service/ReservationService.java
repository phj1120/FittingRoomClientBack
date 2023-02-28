package org.plateer.fittingroomclient.reservation.service;

import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
//import org.plateer.fittingroomclient.payment.dto.AbleReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.GetReservationItemDTO;
import org.plateer.fittingroomclient.payment.dto.TimeOfReservation;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.GetReservationListDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationNoDTO;

import java.util.List;

public interface ReservationService {


    List<GetReservationListDTO> getReservationList(Long coNo);

    GetReservationItemDTO getReservationDetail(Long orNo);

    Long modifyReservationDetail(ReservationNoDTO reservationNoDTO);

    Long modifyDate(ReservationDTO reservationDTO);


    Long cancleReservationDetail(ReservationNoDTO reservationNoDTO);

  // List<Long> getAbleReservation(AbleReservationDTO ableReservationDTO);

    // 예약 가능한 시간대 조회
    List<Long> getAbleTimeOfReservation(TimeOfReservation timeOfReservation);



    Long insertReservation(ReservationDTO reservationDTO);
}
