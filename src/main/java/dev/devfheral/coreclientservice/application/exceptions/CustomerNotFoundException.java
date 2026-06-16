package dev.devfheral.coreclientservice.application.exceptions;

public class CustomerNotFoundException extends RuntimeException {

  public CustomerNotFoundException() {
    super("The Customer doesn't exist");
  }

  public CustomerNotFoundException(String message) {
    super(message);
  }
}
