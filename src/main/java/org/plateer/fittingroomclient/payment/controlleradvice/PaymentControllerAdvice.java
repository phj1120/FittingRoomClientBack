package org.plateer.fittingroomclient.payment.controlleradvice;

import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultDTO Illegal(IllegalArgumentException illegalArgumentException) {
        return ResultDTO.builder().error(illegalArgumentException.getMessage()).build();
    }
}
