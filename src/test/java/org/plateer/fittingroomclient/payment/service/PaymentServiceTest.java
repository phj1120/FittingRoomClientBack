package org.plateer.fittingroomclient.payment.service;

import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.cart.dto.CartDTO;
import org.plateer.fittingroomclient.cart.service.CartService;
import org.plateer.fittingroomclient.payment.dto.PaymentInfoDTO;
import org.plateer.fittingroomclient.payment.dto.TimeOfReservation;
import org.plateer.fittingroomclient.reservation.service.ReservationService;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    CartService cartService;

    @Autowired
    RoomService roomService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    ReservationService reservationService;

    @Test
    void getCart() {
        CartDTO cart = cartService.getCart(23L);

        System.out.println(cart);
    }

    @Test
    void getRoom() {
        RoomDTO room = roomService.getRoom(1L);

        System.out.println(room);
    }

    @Test
    void getPayment() {
        PaymentInfoDTO paymentDetails = paymentService.getPaymentDetails(4L);

        System.out.println(paymentDetails);
    }

    @Test
    void getAbleTimeOfReservation() {
        TimeOfReservation timeOfReservation = new TimeOfReservation(1L, LocalDate.of(2023, 3, 1));
        List<Long> ableTimeOfReservation = reservationService.getAbleTimeOfReservation(timeOfReservation);

        System.out.println(ableTimeOfReservation);
    }
}