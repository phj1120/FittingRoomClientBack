package org.plateer.fittingroomclient.reservation.service;

import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.payment.dto.AbleReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.getReservationListDTO;

import java.util.List;

public interface ReservationService {


    List<getReservationListDTO> getReservationList(Long coNo);

    List<CartProductListDTO> getReservationDetail(Long caNo);

    Long modifyReservationDetail(ReservationDTO reservationDTO);

    List<Long> getAbleReservation(AbleReservationDTO ableReservationDTO);


}
