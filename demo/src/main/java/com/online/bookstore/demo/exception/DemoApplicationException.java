package com.online.bookstore.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DemoApplicationException extends RuntimeException{
    private HttpStatus httpStatus;
    private String message;

    public DemoApplicationException( HttpStatus httpStatus,String message) {
        //super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }
    public DemoApplicationException(String customMessage,String message, HttpStatus httpStatus) {
        super(customMessage);
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
