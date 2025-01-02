package com.laphayen.VisitorQueueSystemFlow.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApplicationException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    @Override
    public String getMessage() {
        return String.format("Error Code: %s, Message: %s", errorCode, errorMessage);

    }
}
