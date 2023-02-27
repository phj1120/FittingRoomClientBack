package org.plateer.fittingroomclient.reservation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.cart.service.CartService;
import org.plateer.fittingroomclient.reservation.dto.GetReservationItemDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.GetReservationListDTO;
import org.plateer.fittingroomclient.reservation.dto.ReservationNoDTO;
import org.plateer.fittingroomclient.reservation.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    private final CartService cartService;

    @GetMapping("list")
    public List<GetReservationListDTO> getReservationList(){

        return reservationService.getReservationList(1L);
    }

    @GetMapping("detail/products/{id}")
    public GetReservationItemDTO getReservationDetail(@PathVariable("id") Long orNo){
        return reservationService.getReservationDetail(orNo);
    }

    @PutMapping("detail/modify")
    public Long modifyReservationDetail(@RequestBody ReservationNoDTO reservationNoDTO){
        return reservationService.modifyReservationDetail(reservationNoDTO);
    }

    @PutMapping("detail/cancle")
    public Long cancleReservationDetail(@RequestBody ReservationNoDTO reservationNoDTO){

        return reservationService.cancleReservationDetail(reservationNoDTO);
    }
}
