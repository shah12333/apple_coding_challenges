package com.example.weather.zipcodeweatherapi.invalid.zipcode;

public class InvalidZipcodeException extends RuntimeException {

    public InvalidZipcodeException() {
        super();
    }

    public InvalidZipcodeException(String message) {
        super(message);
    }

    public InvalidZipcodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidZipcodeException(Throwable cause) {
        super(cause);
    }
}