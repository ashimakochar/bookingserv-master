package com.paypal.bfs.test.bookingserv.util;

import java.util.Map;
import java.util.Objects;

public class GenericUtility {

  public static String getNullField(Map<String,Object> map) {
    return map.entrySet().stream().filter(entry -> Objects.isNull(entry.getValue()))
        .map(entry -> entry.getKey()).findFirst().orElse(null);
  }

}
