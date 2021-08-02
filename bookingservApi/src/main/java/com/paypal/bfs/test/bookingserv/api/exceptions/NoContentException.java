package com.paypal.bfs.test.bookingserv.api.exceptions;

import lombok.Getter;

public class NoContentException extends Exception {

  @Getter
  private final int errorCode;

  public NoContentException(final String errorDescription, final int errorCode) {
    super(errorDescription);
    this.errorCode = errorCode;
  }
}
