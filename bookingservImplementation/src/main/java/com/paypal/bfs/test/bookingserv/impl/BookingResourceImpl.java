package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.Validations.CreateBookingValidations;
import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.exceptions.ValidationException;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.service.BookingResourceService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResourceImpl implements BookingResource {


  private CreateBookingValidations createBookingValidations;

  private BookingResourceService bookingResourceService;

  @Autowired
  public BookingResourceImpl(
      CreateBookingValidations createBookingValidations,
      BookingResourceService bookingResourceService) {
    this.createBookingValidations = createBookingValidations;
    this.bookingResourceService = bookingResourceService;
  }


  @Override
  public ResponseEntity<Booking> create(
      @RequestHeader(value = "transaction-guid", required = false) UUID transactionGuid,
      Booking booking) throws ValidationException {
    createBookingValidations.validate(transactionGuid, booking);
    Booking bookingResponse = bookingResourceService
        .createBooking(transactionGuid, booking);
    return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<List<Booking>> getAll() {
    List<Booking> bookings = bookingResourceService.getAllBookings();
    if (bookings.size() == 0) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(bookings, HttpStatus.OK);
  }

}
