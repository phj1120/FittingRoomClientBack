package org.plateer.fittingroomclient.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Long reNo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime reModifyDt;
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime reCreatDt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate reDt;

    private Long rePrice;

    private String reStatus;

    private Long orNo;
}
