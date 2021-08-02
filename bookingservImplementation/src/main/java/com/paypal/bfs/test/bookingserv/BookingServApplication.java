package com.paypal.bfs.test.bookingserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.paypal.bfs.test.bookingserv.repository")
@EntityScan("com.paypal.bfs.test.bookingserv.entity")
public class BookingServApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingServApplication.class, args);
    }
}