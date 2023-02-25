package org.plateer.fittingroomclient.reservation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.dto.CartProductListDTO;
import org.plateer.fittingroomclient.cart.service.CartService;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;
import org.plateer.fittingroomclient.reservation.dto.getReservationListDTO;
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
    public List<getReservationListDTO> getReservationList(){

        return reservationService.getReservationList(1L);
    }

    @GetMapping("detail/products/{id}")
    public List<CartProductListDTO> getReservationDetail(@PathVariable("id") Long caNo){
        return reservationService.getReservationDetail(caNo);
    }

    @PutMapping("detail/modify")
    public Long modifyReservationDetail(@RequestBody ReservationDTO reservationDTO){
        return reservationService.modifyReservationDetail(reservationDTO);
    }

    @DeleteMapping("detail/delete/{id}")
    public Long deleteReservationDetail(@PathVariable("id") Long cpNo){

        return cartService.deleteCartProduct(cpNo);
    }
}
