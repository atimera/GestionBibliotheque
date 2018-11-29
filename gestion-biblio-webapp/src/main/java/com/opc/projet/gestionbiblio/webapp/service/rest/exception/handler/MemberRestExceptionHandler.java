package com.opc.projet.gestionbiblio.webapp.service.rest.exception.handler;

import com.opc.projet.gestionbiblio.webapp.service.rest.exception.MemberNotFoundException;
import com.opc.projet.gestionbiblio.webapp.service.rest.error.reponse.MemberErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MemberRestExceptionHandler {


    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<MemberErrorResponse> handleException(MemberNotFoundException exc){

        // create a MemberErrorResponse
        MemberErrorResponse error = new MemberErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<MemberErrorResponse> handleException(Exception exc){

        // create a MemberErrorResponse
        MemberErrorResponse error = new MemberErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Bad request: There is an error on the the request ");
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
