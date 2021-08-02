package com.paypal.bfs.test.bookingserv.impl;

import static com.paypal.bfs.test.bookingserv.constants.ExceptionDetails.NO_CONTENT_EXCEPTION;

import com.paypal.bfs.test.bookingserv.Validations.CreateBookingValidations;
import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.exceptions.NoContentException;
import com.paypal.bfs.test.bookingserv.api.exceptions.ValidationException;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.mapper.BookingResponseMapper;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResourceImpl implements BookingResource {

  private BookingRepository bookingRepository;

  private BookingResponseMapper bookingResponseMapper;

  private CreateBookingValidations createBookingValidations;

  @Autowired
  public BookingResourceImpl(
      BookingRepository bookingRepository,
      BookingResponseMapper bookingResponseMapper,
      CreateBookingValidations createBookingValidations) {
    this.bookingRepository = bookingRepository;
    this.bookingResponseMapper = bookingResponseMapper;
    this.createBookingValidations = createBookingValidations;
  }


  @Override
  @Transactional
  public ResponseEntity<Booking> create(@RequestHeader("transaction-guid") UUID transactionGuid,
      Booking booking) throws ValidationException {
    createBookingValidations.validate(transactionGuid, booking);
    com.paypal.bfs.test.bookingserv.entity.Booking bookingEntity;
    if (bookingRepository.checkByTransactionGuid(transactionGuid)) {
      bookingEntity = bookingRepository.findByTransactionGuid(transactionGuid);
    } else {
      bookingEntity = bookingResponseMapper
          .mapToBookingEntity(booking, transactionGuid);
    }

    com.paypal.bfs.test.bookingserv.entity.Booking bookingResponseEntity = bookingRepository
        .save(bookingEntity);

    Booking bookingResponse = bookingResponseMapper.mapToBookingResponse(bookingResponseEntity);
    return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
  }

  @Override
  @Transactional
  public ResponseEntity<List<Booking>> getAll() throws NoContentException {
    List<Booking> bookings = new ArrayList<>();
    Iterable<com.paypal.bfs.test.bookingserv.entity.Booking> bookingList = bookingRepository
        .findAll();
    bookingList.forEach(b -> bookings.add(bookingResponseMapper.mapToBookingResponse(b)));
    if (bookings.size() == 0) {
      throw new NoContentException(NO_CONTENT_EXCEPTION.getDescription(),
          NO_CONTENT_EXCEPTION.getCode());
    }
    return new ResponseEntity<>(bookings, HttpStatus.OK);
  }

}
