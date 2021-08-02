package com.paypal.bfs.test.bookingserv.mapper;

import com.paypal.bfs.test.bookingserv.entity.Address;
import com.paypal.bfs.test.bookingserv.api.model.AddressType;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityMapper {

  public Address mapToAddressEntity(AddressType addressType) {
    Address address = Address.builder().line1(addressType.getLine1())
        .line2(addressType.getLine2()).city(addressType.getCity()).state(addressType.getState())
        .country(addressType.getCountry()).zipCode(addressType.getZipCode()).build();
    return address;
  }

}
