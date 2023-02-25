package org.plateer.fittingroomclient.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TimeOfReservation {
    private Long roNo;
    private LocalDate reservationDt;
}