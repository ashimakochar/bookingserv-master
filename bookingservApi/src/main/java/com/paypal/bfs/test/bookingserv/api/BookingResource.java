package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingserv.api.exceptions.ValidationException;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import java.util.List;
import java.util.UUID;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public interface BookingResource {

  /**
   * Create {@link Booking} resource
   *
   * @param booking the booking object
   * @return the created booking
   */
  @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  ResponseEntity<Booking> create(@RequestHeader("transaction-guid") UUID transactionGuid,@RequestBody Booking booking)
      throws ValidationException;

  /**
   * Return {@link List<Booking>} resource
   *
   * @return List of all Booking objects
   */

  @RequestMapping(value = "/v1/bfs/bookings", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  ResponseEntity<List<Booking>> getAll();
}
