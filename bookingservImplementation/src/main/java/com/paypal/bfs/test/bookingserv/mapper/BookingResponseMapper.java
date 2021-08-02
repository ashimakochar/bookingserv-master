package com.paypal.bfs.test.bookingserv.mapper;

import com.paypal.bfs.test.bookingserv.api.model.AddressType;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.Address;
import java.util.UUID;

public class BookingResponseMapper {

  public static Booking mapToBookingResponse(com.paypal.bfs.test.bookingserv.entity.Booking booking) {
    Booking bookingResponse = new Booking();
    bookingResponse.setId(booking.getBookingId());
    bookingResponse.setFirstName(booking.getFirstName());
    bookingResponse.setLastName(booking.getLastName());
    bookingResponse.setCheckin(booking.getCheckin());
    bookingResponse.setCheckout(booking.getCheckout());
    bookingResponse.setDateOfBirth(booking.getDateOfBirth());
    bookingResponse.setDeposit(booking.getDeposit());
    bookingResponse.setTotalPrice(booking.getTotalPrice());
    bookingResponse.setAddress(mapToAddressType(booking.getAddress()));
    return bookingResponse;
  }

  public static com.paypal.bfs.test.bookingserv.entity.Booking mapToBookingEntity(Booking booking,
      UUID transactionGuid) {
    com.paypal.bfs.test.bookingserv.entity.Booking bookingResponseEntity = com.paypal.bfs.test.bookingserv.entity.Booking
        .builder().bookingId(booking.getId()).firstName(booking.getFirstName())
        .lastName(booking.getLastName()).totalPrice(booking.getTotalPrice())
        .deposit(booking.getDeposit()).checkin(booking.getCheckin()).checkout(booking.getCheckout())
        .dateOfBirth(booking.getDateOfBirth()).transactionGuid(transactionGuid)
        .address(mapToAddressEntity(booking.getAddress(), booking.getId()))
        .build();
    return bookingResponseEntity;
  }

  private static AddressType mapToAddressType(Address address) {
    AddressType addressType = new AddressType();
    addressType.setLine1(address.getLine1());
    addressType.setLine2(address.getLine2());
    addressType.setCity(address.getCity());
    addressType.setState(address.getState());
    addressType.setCountry(address.getCountry());
    addressType.setZipCode(address.getZipCode());
    return addressType;
  }

  private static Address mapToAddressEntity(AddressType addressType, Integer userId) {
    Address address = Address.builder().line1(addressType.getLine1())
        .line2(addressType.getLine2())
        .city(addressType.getCity()).state(addressType.getState()).country(addressType.getCountry())
        .zipCode(addressType.getZipCode()).build();
    return address;
  }

}
