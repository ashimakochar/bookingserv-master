package com.paypal.bfs.test.bookingserv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "address")
public class Address {

  @Id
  @Column(name = "id")
  @SequenceGenerator(
      name = "address_id_sequence",
      sequenceName = "address_id_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "address_id_sequence"
  )
  private Long id;

  @Column(name = "line1", nullable = false)
  @NotNull
  private String line1;

  @Column(name = "line2")
  private String line2;

  @Column(name = "city", nullable = false)
  @NotNull
  private String city;

  @Column(name = "state", nullable = false)
  @NotNull
  private String state;

  @Column(name = "country", nullable = false)
  @NotNull
  private String country;

  @Column(name = "zipCode", nullable = false)
  @NotNull
  private Integer zipCode;

}
