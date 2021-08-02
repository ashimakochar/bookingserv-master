package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import java.util.List;
import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;


public interface BookingResourceService {

  @Transactional
  Booking createBooking(UUID transactionGuid, Booking booking);

  @Transactional
  List<Booking> getAllBookings();

}
