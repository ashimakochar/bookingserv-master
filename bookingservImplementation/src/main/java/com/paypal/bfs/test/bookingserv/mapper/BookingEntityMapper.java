package com.paypal.bfs.test.bookingserv.mapper;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.stereotype.Component;


@Component
public class BookingEntityMapper {

  public com.paypal.bfs.test.bookingserv.entity.Booking mapToBookingEntity(Booking booking,
      Long addressId) {
    com.paypal.bfs.test.bookingserv.entity.Booking bookingEntity = com.paypal.bfs.test.bookingserv.entity.Booking
        .builder().firstName(booking.getFirstName())
        .lastName(booking.getLastName()).checkin(booking.getCheckin())
        .checkout(booking.getCheckout())
        .dateOfBirth(booking.getDateOfBirth())
        .totalPrice(booking.getTotalPrice()).deposit(booking.getDeposit()).addressId(addressId)
        .build();
    return bookingEntity;
  }

}
