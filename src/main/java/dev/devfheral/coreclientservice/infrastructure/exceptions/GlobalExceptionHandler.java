package dev.devfheral.coreclientservice.infrastructure.exceptions;

import dev.devfheral.coreclientservice.application.exceptions.CustomerAlreadyExistsException;
import dev.devfheral.coreclientservice.application.exceptions.CustomerNotFoundException;
import dev.devfheral.coreclientservice.infrastructure.adapters.inbound.rest.dtos.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExists(CustomerAlreadyExistsException ex,
                                                             HttpServletRequest request) {

        ErrorResponse errorResponse  = new ErrorResponse();

        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.CONFLICT.value());
        errorResponse.setError("Customer already exists");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExists(CustomerNotFoundException ex,
                                                             HttpServletRequest request) {

        ErrorResponse errorResponse  = new ErrorResponse();

        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.CONFLICT.value());
        errorResponse.setError("Customer doesn't exist");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
