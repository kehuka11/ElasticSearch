package com.elasticsearch.demo.controller.response.Exception;

public class ContentException extends RuntimeException{
    public ContentException(String message) {
        super(message);
    }
}
