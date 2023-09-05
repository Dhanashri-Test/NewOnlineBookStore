package com.online.bookstore.demo.exception;

import lombok.Data;

@Data
public class AccessDeniedException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Integer fieldValue;

    public AccessDeniedException() {
        //super(String.format("%s not found with %s : '%s'",resourceName,fieldName,fieldValue));
        super("You are unauthorized to process request Kindly correct credentials ");
        //this.resourceName = resourceName;
        //this.fieldName = fieldName;
        //this.fieldValue = fieldValue;
    }
}
