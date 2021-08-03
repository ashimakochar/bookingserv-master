package com.paypal.bfs.test.bookingserv.validations;

import com.paypal.bfs.test.bookingserv.api.exceptions.ValidationException;
import com.paypal.bfs.test.bookingserv.api.model.AddressType;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.constants.Constants;
import com.paypal.bfs.test.bookingserv.util.GenericUtility;
import com.paypal.bfs.test.bookingserv.enums.ExceptionDetails;
import de.cronn.reflection.util.PropertyUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class CreateBookingValidations {

  public void validate(UUID transactionGuid, Booking booking)
      throws ValidationException {
    if (Objects.isNull(transactionGuid)) {
      throw new ValidationException(
          String.format(ExceptionDetails.VALIDATION_EXCEPTION.getDescription(),
              Constants.TRANSACTION_GUID), ExceptionDetails.VALIDATION_EXCEPTION.getCode());
    }
    if (Objects.isNull(booking)) {
      throw new ValidationException(
          String.format(ExceptionDetails.VALIDATION_EXCEPTION.getDescription(),
              Booking.class.getSimpleName()), ExceptionDetails.VALIDATION_EXCEPTION.getCode());
    }
    String nullFieldInBooking = validateBookingFields(booking);
    if (Objects.nonNull(nullFieldInBooking)) {
      throw new ValidationException(
          String.format(ExceptionDetails.VALIDATION_EXCEPTION.getDescription(),
              nullFieldInBooking), ExceptionDetails.VALIDATION_EXCEPTION.getCode());
    }

    String nullFieldInAddressType = validateAddressTypeFields(booking.getAddress());

    if (Objects.nonNull(nullFieldInAddressType)) {
      throw new ValidationException(
          String.format(ExceptionDetails.VALIDATION_EXCEPTION.getDescription(),
              nullFieldInAddressType), ExceptionDetails.VALIDATION_EXCEPTION.getCode());
    }

  }

  private String validateBookingFields(Booking booking) {
    Map<String, Object> parameters = new HashMap<>();
    parameters.put(PropertyUtils.getPropertyName(Booking.class, Booking::getFirstName),
        booking.getFirstName());
    parameters.put(PropertyUtils.getPropertyName(Booking.class, Booking::getLastName),
        booking.getLastName());
    parameters.put(PropertyUtils.getPropertyName(Booking.class, Booking::getDateOfBirth),
        booking.getDateOfBirth());
    parameters.put(PropertyUtils.getPropertyName(Booking.class, Booking::getCheckin),
        booking.getCheckin());
    parameters.put(PropertyUtils.getPropertyName(Booking.class, Booking::getCheckout),
        booking.getCheckout());
    parameters.put(PropertyUtils.getPropertyName(Booking.class, Booking::getTotalPrice),
        booking.getTotalPrice());
    parameters.put(PropertyUtils.getPropertyName(Booking.class, Booking::getDeposit),
        booking.getDeposit());
    parameters.put(PropertyUtils.getPropertyName(Booking.class, Booking::getAddress),
        booking.getAddress());
    return GenericUtility.getNullField(parameters);
  }

  private String validateAddressTypeFields(AddressType addressType) {
    Map<String, Object> parameters = new HashMap<>();
    parameters.put(PropertyUtils.getPropertyName(AddressType.class, AddressType::getLine1),
        addressType.getLine1());
    parameters.put(PropertyUtils.getPropertyName(AddressType.class, AddressType::getCity),
        addressType.getCity());
    parameters.put(PropertyUtils.getPropertyName(AddressType.class, AddressType::getState),
        addressType.getState());
    parameters.put(PropertyUtils.getPropertyName(AddressType.class, AddressType::getCountry),
        addressType.getCountry());
    parameters.put(PropertyUtils.getPropertyName(AddressType.class, AddressType::getZipCode),
        addressType.getZipCode());
    return GenericUtility.getNullField(parameters);
  }

}
