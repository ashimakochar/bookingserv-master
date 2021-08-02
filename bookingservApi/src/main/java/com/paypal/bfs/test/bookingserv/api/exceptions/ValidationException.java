package com.paypal.bfs.test.bookingserv.api.exceptions;

import lombok.Getter;

public class ValidationException extends Exception {


  @Getter
  private final int errorCode;

  public ValidationException(final String errorDescription, final int errorCode) {
    super(errorDescription);
    this.errorCode = errorCode;
  }

}
