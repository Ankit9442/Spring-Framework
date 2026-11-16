package org.example.p03_springbootcrud.exception;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message ){
        super(message);
    }
}
