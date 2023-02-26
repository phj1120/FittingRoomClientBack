package org.plateer.fittingroomclient.reservation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.cart.mapper.CartMapper;
import org.plateer.fittingroomclient.order.mapper.OrderMapper;
import org.plateer.fittingroomclient.payment.dto.AbleReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.GetReservationItemDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.GetReservationListDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationNoDTO;
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
        log.info("=====================================");
        log.info("=====================================");

        log.info(reservationNoDTO.getOrNo());
        return reservationMapper.modifyReservation(reservationNoDTO);
    }

    @Override
    public Long cancleReservationDetail(ReservationNoDTO reservationNoDTO) {
        orderMapper.insertCancleReservation(reservationNoDTO);
        cartMapper.modifyCartItem(reservationNoDTO.getCaNo());
        return reservationMapper.cancleReservation(reservationNoDTO);
    }

    @Override
    public List<Long> getAbleReservation(AbleReservationDTO ableReservationDTO) {
        return null;
    }
}
