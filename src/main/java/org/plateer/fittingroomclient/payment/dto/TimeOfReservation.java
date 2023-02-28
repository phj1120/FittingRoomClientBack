package org.plateer.fittingroomclient.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeOfReservation {
    private Long roNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDt;
}
