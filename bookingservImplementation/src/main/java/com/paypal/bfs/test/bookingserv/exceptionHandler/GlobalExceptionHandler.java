package com.paypal.bfs.test.bookingserv.exceptionHandler;

import static com.paypal.bfs.test.bookingserv.constants.ExceptionDetails.TRANSACTION_EXCEPTION;
import static com.paypal.bfs.test.bookingserv.constants.ExceptionDetails.VALIDATION_EXCEPTION;

import com.paypal.bfs.test.bookingserv.api.exceptions.NoContentException;
import com.paypal.bfs.test.bookingserv.api.exceptions.ValidationException;
import com.paypal.bfs.test.bookingserv.api.model.BookingError;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = {"com.paypal.bfs.test.bookingserv"})
public class GlobalExceptionHandler {

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler({TransactionSystemException.class})
  protected ResponseEntity<Object> badRequest(HttpServletRequest req,
      TransactionSystemException e) {
    if (e.getCause() instanceof ConstraintViolationException) {
      return new ResponseEntity<>(
          createBookingError(HttpStatus.BAD_REQUEST, e.getOriginalException().getMessage(),
              VALIDATION_EXCEPTION.getCode(), req.getRequestURI()),
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(
        createBookingError(HttpStatus.BAD_REQUEST, e.getOriginalException().getMessage(),
            TRANSACTION_EXCEPTION.getCode(), req.getRequestURI()),
        HttpStatus.BAD_REQUEST);
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler({ValidationException.class})
  protected ResponseEntity<Object> badRequest(HttpServletRequest req,
      ValidationException e) {
    return new ResponseEntity<>(createBookingError(HttpStatus.BAD_REQUEST, e.getMessage(),
        e.getErrorCode(), req.getRequestURI()),
        HttpStatus.BAD_REQUEST);
  }

  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  @ExceptionHandler({NoContentException.class})
  protected ResponseEntity<Object> badRequest(HttpServletRequest req,
      NoContentException e) {
    return new ResponseEntity<>(createBookingError(HttpStatus.NO_CONTENT, e.getMessage(),
        e.getErrorCode(), req.getRequestURI()),
        HttpStatus.NO_CONTENT);
  }

  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({Exception.class})
  protected ResponseEntity<Object> genericException(HttpServletRequest req, Exception e) {
    return new ResponseEntity<>(
        createBookingError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null,
            req.getRequestURI()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private BookingError createBookingError(HttpStatus status, String message, Integer errorCode,
      String apiUrl) {
    BookingError bookingError = new BookingError();
    bookingError.setTimestamp(LocalDateTime.now());
    bookingError.setStatus(status.name());
    bookingError.setErrorCode(errorCode);
    bookingError.setMessage(message);
    bookingError.setApiUrl(apiUrl);
    return bookingError;
  }

}
