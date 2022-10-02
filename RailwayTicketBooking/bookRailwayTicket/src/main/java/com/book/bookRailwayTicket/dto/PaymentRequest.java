package com.book.bookRailwayTicket.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class PaymentRequest {
   private String booking_id;
   private double price;
   private String user;

}
