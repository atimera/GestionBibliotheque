package com.opc.projet.gestionbiblio.webapp.service.rest.exception;

public class MemberNotFoundException extends RuntimeException{

    public MemberNotFoundException(String message) {
        super(message);
    }

    public MemberNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MemberNotFoundException(Throwable cause) {
        super(cause);
    }
}
