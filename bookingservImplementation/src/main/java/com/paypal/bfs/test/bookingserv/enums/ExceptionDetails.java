package com.paypal.bfs.test.bookingserv.enums;

import lombok.Getter;

public enum ExceptionDetails {

  VALIDATION_EXCEPTION("Request entered is not Valid , %s is null", 407),
  TRANSACTION_EXCEPTION("Transaction could not succeed", 408);

  @Getter
  private final String description;
  @Getter
  private final int code;

  ExceptionDetails(final String description, final int code) {
    this.description = description;
    this.code = code;
  }


}
