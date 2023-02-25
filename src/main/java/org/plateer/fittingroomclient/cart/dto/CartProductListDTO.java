package org.plateer.fittingroomclient.cart.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartProductListDTO {

    private Boolean cpStatus;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime cpCreateDt;

    private String spSize;

    private String prName;

    private Long prPrice;

    private String prStatus;

}
