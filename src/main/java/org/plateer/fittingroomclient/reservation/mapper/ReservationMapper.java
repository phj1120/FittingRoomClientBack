package org.plateer.fittingroomclient.reservation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.payment.dto.AbleReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.getReservationListDTO;

import java.util.List;

@Mapper
public interface ReservationMapper {

    void insertTest(ReservationDTO reservationDTO);

    List<getReservationListDTO> getReservationList(Long coNo);

    Long modifyReservation(ReservationDTO reservationDTO);

    List<Long> getAbleReservation(AbleReservationDTO ableReservationDTO);

    Long insertReservation(ReservationDTO reservationDTO);
}
