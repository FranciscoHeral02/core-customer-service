package dev.devfheral.coreclientservice.application.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {

  public CustomerAlreadyExistsException() {
    super("The Customer code has already been registered");
  }

  public CustomerAlreadyExistsException(String message) {
    super(message);
  }
}
