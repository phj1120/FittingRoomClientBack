package org.plateer.fittingroomclient.reservation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.reservation.dto.getReservationListDTO;
import org.plateer.fittingroomclient.reservation.mapper.ReservationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ReservationServiceImpl implements ReservationService{
    private final ReservationMapper reservationMapper;
    @Override
    public List<getReservationListDTO> getReservationList(Long coNo) {
        return reservationMapper.getReservationList(coNo);
    }
}
