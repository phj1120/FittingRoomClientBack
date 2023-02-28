package org.plateer.fittingroomclient.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetReservationItemDTO {

    private String orStatus;

    private Long caNo;

    private LocalDate reDt;

    private Long reTime;

    private Long rePrice;

    private Long reNo;

    private Long roNo;

    private String roName;

    private String roAddress;

    private String roDetailAddress;



}
