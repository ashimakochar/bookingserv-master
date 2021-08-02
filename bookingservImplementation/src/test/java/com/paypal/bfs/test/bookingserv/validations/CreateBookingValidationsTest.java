package com.paypal.bfs.test.bookingserv.validations;

import com.paypal.bfs.test.bookingserv.api.exceptions.ValidationException;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.constant.TestConstants;
import com.paypal.bfs.test.bookingserv.util.FileUtil;
import java.util.UUID;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBookingValidationsTest {

  @InjectMocks
  private CreateBookingValidations createBookingValidations;

  private Booking booking;

  @BeforeMethod
  private void init() {
    MockitoAnnotations.openMocks(this);
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_COMPLETE_REQUEST, Booking.class);
  }

  @Test
  public void validateTestSuccessCase() throws ValidationException {
      createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , Booking is null")
  public void validateTestFailureWhenRequestObjectIsNull() throws ValidationException {
    createBookingValidations.validate(UUID.randomUUID(), null);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , transactionGuid is null")
  public void validateTestFailureWhenTransactionGuidIsNull() throws ValidationException {
    createBookingValidations.validate(null, booking);
  }

}
