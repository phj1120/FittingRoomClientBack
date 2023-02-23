package org.plateer.fittingroomclient.reservation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.cart.mapper.CartMapper;
import org.plateer.fittingroomclient.order.mapper.OrderMapper;
import org.plateer.fittingroomclient.payment.dto.AbleReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
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
    public List<Long> getAbleReservation(AbleReservationDTO ableReservationDTO) {
        return null;
    }
}
