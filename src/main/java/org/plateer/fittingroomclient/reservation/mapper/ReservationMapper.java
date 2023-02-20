package org.plateer.fittingroomclient.reservation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;

@Mapper
public interface ReservationMapper {

    void insertTest(ReservationDTO reservationDTO);
}
