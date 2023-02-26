package org.plateer.fittingroomclient.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetReservationListDTO {

    private Long orNo;

    private String orStatus;

    private Long caNo;

    private Long reNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reDt;

    private Long rePrice;

    private Long roNo;
    private String roName;

    private String roAddress;

    private String roDetailAddress;

    private String rfName;


}
