package org.plateer.fittingroomclient.reservation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.cart.mapper.CartMapper;
import org.plateer.fittingroomclient.order.mapper.OrderMapper;
//import org.plateer.fittingroomclient.payment.dto.AbleReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.GetReservationItemDTO;
import org.plateer.fittingroomclient.payment.dto.TimeOfReservation;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.GetReservationListDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationNoDTO;
import org.plateer.fittingroomclient.reservation.mapper.ReservationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<GetReservationListDTO> getReservationList(Long coNo) {
        return reservationMapper.getReservationList(coNo);
    }

    @Override
    public GetReservationItemDTO getReservationDetail(Long orNo) {

        return reservationMapper.getReservationDetail(orNo);
    }

    @Override
    public Long modifyReservationDetail(ReservationNoDTO reservationNoDTO) {
        orderMapper.insertModifyReservation(reservationNoDTO);

        return reservationMapper.modifyReservation(reservationNoDTO);
    }

    @Override
    public Long modifyDate(ReservationDTO reservationDTO) {
        return reservationMapper.modifyDate(reservationDTO);
    }

    @Override
    public Long cancleReservationDetail(ReservationNoDTO reservationNoDTO) {
        orderMapper.insertCancleReservation(reservationNoDTO);
        cartMapper.modifyCartItem(reservationNoDTO.getCaNo());
        return reservationMapper.cancleReservation(reservationNoDTO);
    }

    @Override
    public List<Long> getAbleTimeOfReservation(TimeOfReservation timeOfReservation) {
        LocalDate reservationDt = timeOfReservation.getReservationDt();
        Long roNo = timeOfReservation.getRoNo();
        // TODO ?????? ????????? ?????? ????????? ????????? ??????

        // ?????? ????????? ?????? ????????? ?????? ??????
        List<ReservationDTO> existReservation = reservationMapper.getExistReservation(timeOfReservation);
        List<Long> ableSchedules = new ArrayList<>(List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));

        existReservation.forEach((reservationDTO -> {
            Long reTime = reservationDTO.getReTime();
            // ???????????? ?????? ??????
            ableSchedules.remove(reTime);
        }));

        return ableSchedules;
    }

    @Override
    public Long insertReservation(ReservationDTO reservationDTO) {
        Long count = reservationMapper.insertReservation(reservationDTO);
        if (count != 1) {
            throw new IllegalArgumentException("Reservation ?????? ??????");
        }

        return reservationDTO.getReNo();
    }
}
