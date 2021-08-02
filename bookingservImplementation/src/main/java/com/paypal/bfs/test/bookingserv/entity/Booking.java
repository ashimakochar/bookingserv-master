package com.paypal.bfs.test.bookingserv.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "booking", indexes = {
    @Index(name="transaction_validator", columnList = "transaction_guid", unique = true)
})

public class Booking {

  @Id
  @SequenceGenerator(
      name = "booking_id_sequence",
      sequenceName = "booking_id_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "booking_id_sequence"
  )
  @Column(name = "id", nullable = false)
  @NotNull
  private Integer bookingId;

  @Column(name = "transaction_guid", nullable = false)
  @NotNull
  private UUID transactionGuid;

  @Column(name = "first_name", nullable = false)
  @NotNull
  private String firstName;

  @Column(name = "last_name", nullable = false)
  @NotNull
  private String lastName;

  @Column(name = "date_of_birth", nullable = false)
  @NotNull
  private LocalDate dateOfBirth;

  @Column(name = "checkin", nullable = false)
  @NotNull
  private LocalDateTime checkin;

  @Column(name = "checkout", nullable = false)
  @NotNull
  private LocalDateTime checkout;

  @Column(name = "total_price", nullable = false)
  @NotNull
  private Double totalPrice;

  @Column(name = "deposit", nullable = false)
  @NotNull
  private Double deposit;

  @Column(name = "address_id", insertable = false , updatable = false)
  private Long addressId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;

}
