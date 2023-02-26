package org.plateer.fittingroomclient.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationNoDTO {

    private Long orNo;
    private Long caNo;

    private Long reNo;
}
