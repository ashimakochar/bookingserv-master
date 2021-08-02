package com.paypal.bfs.test.bookingserv.service.impl;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.mapper.BookingResponseMapper;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.service.BookingResourceService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingResourceServiceImpl implements BookingResourceService {

  private BookingRepository bookingRepository;



  @Autowired
  public BookingResourceServiceImpl(
      BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  @Override
  public Booking createBooking(UUID transactionGuid, Booking booking) {
    com.paypal.bfs.test.bookingserv.entity.Booking bookingEntity;
    if (bookingRepository.checkByTransactionGuid(transactionGuid)) {
      bookingEntity = bookingRepository.findByTransactionGuid(transactionGuid);
    } else {
      com.paypal.bfs.test.bookingserv.entity.Booking bookingRequestEntity = BookingResponseMapper
          .mapToBookingEntity(booking, transactionGuid);
      bookingEntity = bookingRepository
          .save(bookingRequestEntity);
    }
    Booking bookingResponse = BookingResponseMapper.mapToBookingResponse(bookingEntity);
    return bookingResponse;
  }

  @Override
  public List<Booking> getAllBookings() {
    List<Booking> bookings = new ArrayList<>();
    Iterable<com.paypal.bfs.test.bookingserv.entity.Booking> bookingList = bookingRepository
        .findAll();
    bookingList.forEach(b -> bookings.add(BookingResponseMapper.mapToBookingResponse(b)));
    return bookings;
  }
}
