package com.book.bookRailwayTicket.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DisplayTicket {

   private Ticketinfo ticketinfo;
   private String booking_id;
   private double total_price;
   private String status;


}
