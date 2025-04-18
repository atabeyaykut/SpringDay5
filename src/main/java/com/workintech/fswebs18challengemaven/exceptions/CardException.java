package com.workintech.fswebs18challengemaven.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CardException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CardException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
