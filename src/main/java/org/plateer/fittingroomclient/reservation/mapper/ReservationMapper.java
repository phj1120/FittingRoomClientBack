package org.plateer.fittingroomclient.reservation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.getReservationListDTO;

import java.util.List;

@Mapper
public interface ReservationMapper {

    void insertTest(ReservationDTO reservationDTO);

    List<getReservationListDTO> getReservationList(Long coNo);
}
