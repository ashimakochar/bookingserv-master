package com.paypal.bfs.test.bookingserv.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.paypal.bfs.test.bookingserv.api.exceptions.ValidationException;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.constant.TestConstants;
import com.paypal.bfs.test.bookingserv.constants.ExceptionDetails;
import com.paypal.bfs.test.bookingserv.exceptionHandler.GlobalExceptionHandler;
import com.paypal.bfs.test.bookingserv.service.impl.BookingResourceServiceImpl;
import com.paypal.bfs.test.bookingserv.util.FileUtil;
import com.paypal.bfs.test.bookingserv.validations.CreateBookingValidations;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.TransactionSystemException;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(BookingResourceImpl.class)
public class BookingResourceImplTest {

  private static final String CREATE_BOOKING = "/v1/bfs/booking";

  private static final String GET_ALL_BOOKING = "/v1/bfs/bookings";

  private static final String TRANSACTION_UUID = "transaction-guid";
  @InjectMocks
  BookingResourceImpl bookingResource;

  @Mock
  private CreateBookingValidations createBookingValidations;

  @Mock
  private BookingResourceServiceImpl bookingResourceService;

  private MockMvc mockMvc;

  private Booking booking;

  private List<Booking> bookingList;

  @Before
  public void setup() {
    booking = (Booking) FileUtil
        .getObjectFromFile(TestConstants.BOOKING_COMPLETE_RESPONSE, Booking.class);
    bookingList = (List<Booking>) FileUtil
        .getObjectListFromFile(TestConstants.BOOKING_GET_ALL_RESPONSE, Booking.class);
    mockMvc = MockMvcBuilders.standaloneSetup(bookingResource)
        .setControllerAdvice(new GlobalExceptionHandler()).build();
  }


  @Test
  public void createTest() throws Exception {
    Mockito.doNothing().when(createBookingValidations)
        .validate(Mockito.any(UUID.class), Mockito.any(
            Booking.class));
    Mockito.doReturn(booking)
        .when(bookingResourceService).createBooking(Mockito.any(UUID.class), Mockito.any(
        Booking.class));
    mockMvc.perform(
        post(CREATE_BOOKING).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .header(
                TRANSACTION_UUID, UUID.randomUUID())
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(FileUtil
            .getContentsOfFile(TestConstants.BOOKING_COMPLETE_REQUEST))).andExpect(
        jsonPath("$.id").exists())
        .andExpect(jsonPath("$.address").exists())
        .andExpect(jsonPath("$.first_name").exists())
        .andExpect(jsonPath("$.last_name").exists())
        .andExpect(jsonPath("$.deposit").exists())
        .andExpect(jsonPath("$.date_of_birth").exists())
        .andExpect(jsonPath("$.checkin").exists())
        .andExpect(jsonPath("$.checkout").exists())
        .andExpect(jsonPath("$.total_price").exists())
        .andExpect(jsonPath("$.address.line1").exists())
        .andExpect(jsonPath("$.address.city").exists())
        .andExpect(jsonPath("$.address.state").exists())
        .andExpect(jsonPath("$.address.country").exists())
        .andExpect(jsonPath("$.address.zip_code").exists())
        .andExpect(status().isCreated());

  }

  @Test
  public void createTestValidationExceptionFailureCase() throws Exception {
    Mockito.doThrow(new ValidationException(
        String.format(ExceptionDetails.VALIDATION_EXCEPTION.getDescription(), TRANSACTION_UUID),
        ExceptionDetails.VALIDATION_EXCEPTION.getCode())).when(createBookingValidations)
        .validate(Mockito.any(UUID.class), Mockito.any(
            Booking.class));
    mockMvc.perform(
        post(CREATE_BOOKING).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .header(
                TRANSACTION_UUID, UUID.randomUUID())
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(FileUtil
            .getContentsOfFile(TestConstants.BOOKING_COMPLETE_REQUEST)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void createTestTransactionExceptionFailureCase() throws Exception {
    Mockito.doThrow(new TransactionSystemException(
        String.format(ExceptionDetails.VALIDATION_EXCEPTION.getDescription(), TRANSACTION_UUID),
        new ConstraintViolationException(null))).when(createBookingValidations)
        .validate(Mockito.any(UUID.class), Mockito.any(
            Booking.class));
    mockMvc.perform(
        post(CREATE_BOOKING).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .header(
                TRANSACTION_UUID, UUID.randomUUID())
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(FileUtil
            .getContentsOfFile(TestConstants.BOOKING_COMPLETE_REQUEST)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void getAllTestSuccess() throws Exception {
    Mockito.doReturn(bookingList).when(bookingResourceService)
        .getAllBookings();
    mockMvc.perform(
        get(GET_ALL_BOOKING).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(FileUtil
            .getContentsOfFile(TestConstants.BOOKING_GET_ALL_RESPONSE)))
        .andExpect(status().isOk());
  }

  @Test
  public void getAllTestNoContentCase() throws Exception {
    Mockito.doReturn(new ArrayList<Booking>()).when(bookingResourceService)
        .getAllBookings();
    mockMvc.perform(
        get(GET_ALL_BOOKING).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(FileUtil
            .getContentsOfFile(TestConstants.BOOKING_GET_ALL_RESPONSE)))
        .andExpect(status().isNoContent());
  }

}
