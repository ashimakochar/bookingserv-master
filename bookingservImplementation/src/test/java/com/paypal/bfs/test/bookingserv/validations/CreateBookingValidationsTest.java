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

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , firstName is null")
  public void validateTestFailureWhenFirstNameIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_FIRST_NAME_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , lastName is null")
  public void validateTestFailureWhenLastNameIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_LAST_NAME_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , address is null")
  public void validateTestFailureWhenAddressIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_ADDRESS_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , checkin is null")
  public void validateTestFailureWhenCheckinIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_CHECKIN_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , checkout is null")
  public void validateTestFailureWhenCheckoutIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_CHECKOUT_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , deposit is null")
  public void validateTestFailureWhenDepositIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_DEPOSIT_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , dateOfBirth is null")
  public void validateTestFailureWhenDOBIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_DOB_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , totalPrice is null")
  public void validateTestFailureWhenTotalPriceIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_TOTAL_PRICE_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , line1 is null")
  public void validateTestFailureWhenLine1IsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_LINE1_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test
  public void validateTestFailureWhenLine2IsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_LINE2_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , city is null")
  public void validateTestFailureWhenCityIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_CITY_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , state is null")
  public void validateTestFailureWhenStateIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_STATE_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , country is null")
  public void validateTestFailureWhenCountryIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_COUNTRY_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }
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

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , firstName is null")
    public void validateTestFailureWhenFirstNameIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_FIRST_NAME_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , lastName is null")
    public void validateTestFailureWhenLastNameIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_LAST_NAME_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , address is null")
    public void validateTestFailureWhenAddressIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_ADDRESS_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , checkin is null")
    public void validateTestFailureWhenCheckinIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_CHECKIN_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , checkout is null")
    public void validateTestFailureWhenCheckoutIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_CHECKOUT_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , deposit is null")
    public void validateTestFailureWhenDepositIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_DEPOSIT_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , dateOfBirth is null")
    public void validateTestFailureWhenDOBIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_DOB_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , totalPrice is null")
    public void validateTestFailureWhenTotalPriceIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_TOTAL_PRICE_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , line1 is null")
    public void validateTestFailureWhenLine1IsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_LINE1_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test
    public void validateTestFailureWhenLine2IsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_LINE2_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , city is null")
    public void validateTestFailureWhenCityIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_CITY_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , state is null")
    public void validateTestFailureWhenStateIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_STATE_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , country is null")
    public void validateTestFailureWhenCountryIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_COUNTRY_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

    @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , zipCode is null")
    public void validateTestFailureWhenZipCodeIsNull() throws ValidationException {
      booking = (Booking) FileUtil
          .getObjectFromFile(TestConstants.BOOKING_ZIP_CODE_MISSING_REQUEST, Booking.class);
      createBookingValidations.validate(UUID.randomUUID(), booking);
    }

  }

  @Test(expectedExceptions = ValidationException.class, expectedExceptionsMessageRegExp = "Request entered is not Valid , zipCode is null")
  public void validateTestFailureWhenZipCodeIsNull() throws ValidationException {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_ZIP_CODE_MISSING_REQUEST, Booking.class);
    createBookingValidations.validate(UUID.randomUUID(), booking);
  }

}
