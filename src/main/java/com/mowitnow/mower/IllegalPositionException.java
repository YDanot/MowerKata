package com.mowitnow.mower;

public class IllegalPositionException extends RuntimeException {

    public IllegalPositionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}