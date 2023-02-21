package org.plateer.fittingroomclient.reservation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.reservation.dto.getReservationListDTO;
import org.plateer.fittingroomclient.reservation.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("list")
    public List<getReservationListDTO> getReservationList(){

        return reservationService.getReservationList(1L);
    }

    @GetMapping("detail/{id}")
    public List<getReservationListDTO> getReservationDetail(@PathVariable("id") Long caNo){

        return reservationService.getReservationList(1L);
    }
}
