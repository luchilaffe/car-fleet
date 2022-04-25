package com.viemed.carfleet.exceptions;

public class ErrorMessage {

    private String exception;
    private String message;
    private String path;

    public ErrorMessage(Exception exception, String path) {
        this.exception = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = path;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
    	return new StringBuilder("ErrorMessage{")
    			.append("exception='").append(exception).append('\'')
    			.append(", message='").append(message).append('\'')
    			.append(", path='").append(path).append('\'').append('}')
    			.toString();
    }

}

