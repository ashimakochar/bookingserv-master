package com.paypal.test.functionalTests;

import com.paypal.bfs.test.bookingserv.entity.Address;
import com.paypal.bfs.test.bookingserv.entity.Booking;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
    BookingRepository.class})
@EntityScan(basePackageClasses = {Booking.class,
    Address.class})
public class BookingServFunctionalTests {

  public static void main(String[] args) {
    SpringApplication.run(BookingServFunctionalTests.class, args);
  }
}
