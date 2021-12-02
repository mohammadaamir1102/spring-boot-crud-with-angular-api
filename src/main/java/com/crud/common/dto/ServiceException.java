package com.crud.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends Exception {

    private HttpStatus status;
    private ServiceError serviceError;

    public ServiceException(ServiceError serviceError, HttpStatus status) {
        super(serviceError.getMsg());
        this.serviceError = serviceError;
        this.status = status;
    }

}
