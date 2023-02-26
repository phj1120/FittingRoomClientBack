package org.plateer.fittingroomclient.reservation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroomclient.payment.dto.AbleReservationDTO;

import org.plateer.fittingroomclient.reservation.dto.GetReservationItemDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.GetReservationListDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationNoDTO;

import java.util.List;

@Mapper
public interface ReservationMapper {

    void insertTest(ReservationDTO reservationDTO);

    GetReservationItemDTO getReservationDetail(Long orNo);

    List<GetReservationListDTO> getReservationList(Long coNo);

    Long modifyReservation(ReservationNoDTO reservationNoDTO);

    Long cancleReservation(ReservationNoDTO reservationNoDTO);

    List<Long> getAbleReservation(AbleReservationDTO ableReservationDTO);

}
