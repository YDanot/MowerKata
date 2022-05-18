package com.mowitnow.mower.exception;

public class CommandUnknownException extends RuntimeException {
    public CommandUnknownException(String message) {
        super(message);
    }
}