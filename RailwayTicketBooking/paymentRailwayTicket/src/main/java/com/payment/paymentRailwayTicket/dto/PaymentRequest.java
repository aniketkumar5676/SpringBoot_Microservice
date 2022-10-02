package com.payment.paymentRailwayTicket.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private String booking_id;
    private double price;
    private String user;

}
