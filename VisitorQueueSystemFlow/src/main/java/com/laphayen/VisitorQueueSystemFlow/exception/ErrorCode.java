package com.laphayen.VisitorQueueSystemFlow.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ErrorCode {

    USER_ALREADY_IN_QUEUE(HttpStatus.CONFLICT, "USER_QUEUE-001", "The user is already registered in the queue");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    public ApplicationException toApplicationException() {
        return new ApplicationException(httpStatus, errorCode, errorMessage);

    }

    public ApplicationException toApplicationException(Object... args) {
        return new ApplicationException(httpStatus, errorCode, errorMessage);

    }

}
