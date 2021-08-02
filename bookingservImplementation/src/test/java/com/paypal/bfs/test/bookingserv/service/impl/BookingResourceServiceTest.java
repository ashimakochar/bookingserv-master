package com.paypal.bfs.test.bookingserv.service.impl;


import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.constant.TestConstants;
import com.paypal.bfs.test.bookingserv.util.FileUtil;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BookingResourceServiceTest {

  @Mock
  private BookingRepository bookingRepository;

  @InjectMocks
  private BookingResourceServiceImpl bookingResourceService;

  private Booking booking;

  private List<com.paypal.bfs.test.bookingserv.entity.Booking> bookingList;

  private com.paypal.bfs.test.bookingserv.entity.Booking bookingEntity;

  private static final UUID TRANSACTION_GUID= UUID.fromString("123e4567-e89b-12d3-a456-426614174099");


  @BeforeMethod
  private void init() {
    MockitoAnnotations.openMocks(this);
    bookingList = (List<com.paypal.bfs.test.bookingserv.entity.Booking>) FileUtil
        .getObjectListFromFile(TestConstants.BOOKING_GET_ALL_RESPONSE, com.paypal.bfs.test.bookingserv.entity.Booking.class);
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_COMPLETE_REQUEST, Booking.class);
    bookingEntity = (com.paypal.bfs.test.bookingserv.entity.Booking)FileUtil
        .getObjectFromFile(TestConstants.BOOKING_ENTITY_COMPLETE_RESPONSE, com.paypal.bfs.test.bookingserv.entity.Booking.class);
  }


  @Test
  public void createBookingTestWhenBookingExistsInDB() {
    Mockito.when(bookingRepository.checkByTransactionGuid(TRANSACTION_GUID))
        .thenReturn(true);
    Mockito.when(bookingRepository.findByTransactionGuid(TRANSACTION_GUID))
        .thenReturn(bookingEntity);
    Booking bookingResponse = bookingResourceService.createBooking(TRANSACTION_GUID, booking);
    Assert.assertNotNull(bookingResponse);
    Assert.assertEquals(bookingResponse.getId(),bookingEntity.getBookingId());
    Mockito.verify(bookingRepository,Mockito.never()).save(bookingEntity);
    Mockito.verify(bookingRepository).findByTransactionGuid(TRANSACTION_GUID);

  }

  @Test
  public void createBookingTestWhenBookingDoesNotExistsInDB() {
    Mockito.when(bookingRepository.checkByTransactionGuid(TRANSACTION_GUID))
        .thenReturn(false);
    Mockito.when(bookingRepository.save(Mockito.any(com.paypal.bfs.test.bookingserv.entity.Booking.class)))
        .thenReturn(bookingEntity);
    Booking bookingResponse = bookingResourceService.createBooking(TRANSACTION_GUID, booking);
    Assert.assertNotNull(bookingResponse);
    Assert.assertEquals(bookingResponse.getId(),bookingEntity.getBookingId());
    Mockito.verify(bookingRepository).save(Mockito.any(
        com.paypal.bfs.test.bookingserv.entity.Booking.class));
    Mockito.verify(bookingRepository,Mockito.never()).findByTransactionGuid(TRANSACTION_GUID);
  }

  @Test
  public void getAllBookingsTest() {
    Collection<com.paypal.bfs.test.bookingserv.entity.Booking> collection = bookingList;
    Mockito.when(bookingRepository.findAll()).thenReturn(collection);
    List<Booking> bookingResponse = bookingResourceService.getAllBookings();
    Assert.assertNotNull(bookingResponse);
    Assert.assertEquals(bookingResponse.size(),2);
    Mockito.verify(bookingRepository).findAll();
  }

}
