package org.plateer.fittingroomclient.reservation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.cart.mapper.CartMapper;
import org.plateer.fittingroomclient.order.mapper.OrderMapper;
import org.plateer.fittingroomclient.payment.dto.TimeOfReservation;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.getReservationListDTO;
import org.plateer.fittingroomclient.reservation.mapper.ReservationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ReservationServiceImpl implements ReservationService {
    private final ReservationMapper reservationMapper;
    private final CartMapper cartMapper;

    private final OrderMapper orderMapper;

    @Override
    public List<getReservationListDTO> getReservationList(Long coNo) {
        return reservationMapper.getReservationList(coNo);
    }

    @Override
    public List<CartProductListDTO> getReservationDetail(Long caNo) {

        return cartMapper.getReservationDetail(caNo);
    }

    @Override
    public Long modifyReservationDetail(ReservationDTO reservationDTO) {
        orderMapper.insertModifyReservation(reservationDTO.getReNo());
        return reservationMapper.modifyReservation(reservationDTO);
    }

    @Override
    public List<Long> getAbleTimeOfReservation(TimeOfReservation timeOfReservation) {
        LocalDate reservationDt = timeOfReservation.getReservationDt();
        Long roNo = timeOfReservation.getRoNo();
        // TODO 해당 장소가 예약 가능한 날이지 확인

        // 해당 장소의 예약 가능한 시간 확인
        List<ReservationDTO> existReservation = reservationMapper.getExistReservation(timeOfReservation);
        List<Long> ableSchedules = List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        existReservation.forEach((reservationDTO -> {
            Long reTime = reservationDTO.getReTime();
            // 존재하는 일정 삭제
            ableSchedules.remove(reTime);
        }));

        return ableSchedules;
    }

    @Override
    public Long insertReservation(ReservationDTO reservationDTO) {
        Long count = reservationMapper.insertReservation(reservationDTO);
        if (count != 1) {
            throw new IllegalArgumentException("Reservation 추가 실패");
        }

        return reservationDTO.getReNo();
    }
}
