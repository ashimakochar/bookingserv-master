package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.test.functionalTests.BookingServFunctionalTests;
import com.paypal.bfs.test.bookingserv.constant.TestConstants;
import com.paypal.bfs.test.bookingserv.entity.Booking;
import com.paypal.bfs.test.bookingserv.util.FileUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BookingServFunctionalTests.class, Booking.class})
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookingRepositoryTest {


  @Autowired
  public BookingRepository bookingRepository;

  @Test
  public void test1() {
    Iterable<Booking> bookingIterable = bookingRepository.findAll();
    List<Booking> bookingList = new ArrayList<>();
    bookingIterable.forEach(b -> bookingList.add(b));
    Assert.assertNotNull(bookingList);
    Assert.assertEquals(bookingList.size(), 0);
  }

  @Test
  public void test2() {
    Booking booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_ENTITY_COMPLETE_REQUEST, Booking.class);
    Booking bookingResponse = bookingRepository.save(booking);
    Iterable<Booking> bookingIterable = bookingRepository.findAll();
    List<Booking> bookingList = new ArrayList<>();
    bookingIterable.forEach(b -> bookingList.add(b));
    Assert.assertNotNull(bookingResponse);
    Assert.assertEquals(bookingList.size(), 1);
    Assert.assertNotNull(bookingResponse.getBookingId());
    validate(bookingResponse);
  }

  @Test
  public void test3() {
    Iterable<Booking> bookingIterable = bookingRepository.findAll();
    List<Booking> bookingList = new ArrayList<>();
    bookingIterable.forEach(b -> bookingList.add(b));
    Assert.assertNotNull(bookingList);
    Assert.assertEquals(bookingList.size(), 1);
    Assert.assertNotNull(bookingList.get(0).getBookingId());
    validate(bookingList.get(0));
  }

  private boolean validate(Booking bookingResponse) {
    Booking ref = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_ENTITY_COMPLETE_RESPONSE, Booking.class);
    return bookingResponse.equals(ref) ? true : false;
  }


}
