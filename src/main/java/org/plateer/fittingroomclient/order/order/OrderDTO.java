package org.plateer.fittingroomclient.order.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long orNo;
    private String orStatus;
    private LocalDateTime orCreateDt;
    private Long caNo;

    public OrderDTO(String orStatus, Long caNo) {
        this.orStatus = orStatus;
        this.caNo = caNo;
    }
}
