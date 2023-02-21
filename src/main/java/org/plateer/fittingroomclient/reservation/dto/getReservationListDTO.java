package org.plateer.fittingroomclient.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class getReservationListDTO {

    private Long caNo;

    private Long reNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate reDt;

    private Long rePrice;

    private Long roNo;
    private String roName;

    private String prfName;


}
