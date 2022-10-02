package com.book.bookRailwayTicket.dto;

import lombok.Data;

@Data
public class PaymentResponse {
    private String booking_id;
    private String payment_id;
    private String status;
    private double total_price;

}
