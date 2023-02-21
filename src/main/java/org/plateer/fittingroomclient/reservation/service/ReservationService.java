package org.plateer.fittingroomclient.reservation.service;

import org.plateer.fittingroomclient.reservation.dto.getReservationListDTO;

import java.util.List;

public interface ReservationService {


    List<getReservationListDTO> getReservationList(Long coNo);

    
}
