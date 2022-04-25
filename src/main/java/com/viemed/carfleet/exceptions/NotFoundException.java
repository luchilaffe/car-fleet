package com.viemed.carfleet.exceptions;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3476453756520843236L;
    private static final String DESCRIPTION = "Not Found Exception (404)";

    public NotFoundException(String detail) {
        super(new StringBuilder(DESCRIPTION).append(": ").append(detail).toString());
    }
}
