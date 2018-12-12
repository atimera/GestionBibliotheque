package com.opc.projet.gestionbiblio.rest.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionResponse {

    private Date titmestamp;
    private String message;
    private String details;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date titmestamp, String message, String details) {
        this.titmestamp = titmestamp;
        this.message = message;
        this.details = details;
    }
}
