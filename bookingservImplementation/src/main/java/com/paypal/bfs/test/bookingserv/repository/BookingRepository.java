package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.entity.Booking;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

  @Query("select case when count(b)> 0 then true else false end from Booking b where b.transactionGuid= :transactionGuid")
  boolean checkByTransactionGuid(@Param("transactionGuid") UUID transactionGuid);

  @Query("select b from Booking b where b.transactionGuid= :transactionGuid")
  Booking findByTransactionGuid(@Param("transactionGuid") UUID transactionGuid);

}
