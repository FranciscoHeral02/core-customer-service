package dev.devfheral.coreclientservice.infrastructure.exceptions;

import dev.devfheral.coreclientservice.application.exceptions.CustomerAlreadyExistsException;
import dev.devfheral.coreclientservice.application.exceptions.CustomerNotFoundException;
import dev.devfheral.coreclientservice.infrastructure.adapters.inbound.rest.dtos.ErrorResponse;
import dev.devfheral.coreclientservice.infrastructure.adapters.inbound.rest.dtos.ValidationErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
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

    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setTimestamp(OffsetDateTime.now());
    errorResponse.setStatus(HttpStatus.CONFLICT.value());
    errorResponse.setError("Customer already exists");
    errorResponse.setMessage(ex.getMessage());
    errorResponse.setPath(request.getRequestURI());

    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
  }

  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(CustomerNotFoundException ex,
                                                      HttpServletRequest request) {

    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setTimestamp(OffsetDateTime.now());
    errorResponse.setMessage(ex.getMessage());
    errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    errorResponse.setError("Customer doesn't exist");
    errorResponse.setPath(request.getRequestURI());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ValidationErrorResponse> handleValidationError(
          ConstraintViolationException ex, HttpServletRequest request) {

    Map<String, String> errors = new HashMap<>();

    ex.getConstraintViolations().forEach(violation -> {
      String propertyPath = violation.getPropertyPath().toString();
      String fieldName = propertyPath.substring(propertyPath.lastIndexOf('.') + 1);
      errors.put(fieldName, violation.getMessage());
    });

    ValidationErrorResponse errorResponse = new ValidationErrorResponse();

    errorResponse.setTimestamp(OffsetDateTime.now());
    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    errorResponse.setError("Customer already exists");
    errorResponse.setFields(errors);
    errorResponse.setPath(request.getRequestURI());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
}
