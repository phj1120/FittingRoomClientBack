package org.plateer.fittingroomclient.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate reDt;
    //2021-12-22 09:00:00 ~ 2021-12-22 10:00:00

    private Long reTime;

    private Long rePrice;

    private String reStatus;

    private Long orNo;


    public ReservationDTO(LocalDate reDt, Long reTime, Long rePrice, String reStatus, Long orNo) {
        this.reDt = LocalDate.from(reDt.atStartOfDay());
        this.reTime = reTime;
        this.rePrice = rePrice;
        this.reStatus = reStatus;
        this.orNo = orNo;
    }
}
