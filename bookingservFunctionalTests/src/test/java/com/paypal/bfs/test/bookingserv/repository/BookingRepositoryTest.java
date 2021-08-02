/*
package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.api.exceptions.ValidationException;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.impl.constant.TestConstants;
import com.paypal.bfs.test.bookingserv.service.impl.BookingResourceImpl;
import com.paypal.bfs.test.bookingserv.mapper.BookingResponseMapper;
import com.paypal.bfs.test.bookingserv.util.FileUtil;
import java.util.UUID;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookingResourceImpl.class)
@ActiveProfiles("test")
public class BookingRepositoryTest {

  @Autowired
  public BookingResourceImpl bookingResource;

  @Autowired
  public BookingRepository bookingRepository;

  @Autowired
  public BookingResponseMapper bookingResponseMapper;

  public void createBookingTest() throws ValidationException {
    Booking booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_COMPLETE_REQUEST, Booking.class);
    UUID transactionGuid = UUID.randomUUID();
    bookingResource.create(transactionGuid, booking);
    com.paypal.bfs.test.bookingserv.entity.Booking bookingEntity = bookingRepository
        .findByTransactionGuid(transactionGuid);
    Booking bookingResponse = bookingResponseMapper.mapToBookingResponse(bookingEntity);
    Assert.assertNotNull(bookingResponse);
    Assert.assertEquals(bookingResponse.hashCode(), booking.hashCode());
  }


}
*/
