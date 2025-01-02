package com.laphayen.VisitorQueueSystemFlow.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ApplicationAdvice {

    @ExceptionHandler(ApplicationException.class)
    Mono<ResponseEntity<ServerExceptionResponse>> applicationExceptionHandler (ApplicationException e) {
        return Mono.just(ResponseEntity
                .status(e.getHttpStatus())
                .body(new ServerExceptionResponse(e.getErrorCode(), e.getErrorMessage())));

    }

    public record ServerExceptionResponse(String code, String reason){

    }

}

