package org.plateer.fittingroomclient.reservation.service;

import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.reservation.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.plateer.fittingroomclient.reservation.dto.ReservationDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
public class ReservationServiceTests {

    @Autowired
    private ReservationMapper reservationMapper;

    @Test
    public void testInserts() {
        IntStream.rangeClosed(1, 4).forEach((i) -> {

            ReservationDTO reservationDTO = ReservationDTO.builder()
                    .reDt(LocalDate.now())
                    .rePrice(20000L)
                    .reStatus("승인")
                    .orNo((long)i)
                    .build();
            reservationMapper.insertTest(reservationDTO);
        });//end loop
    }
}
