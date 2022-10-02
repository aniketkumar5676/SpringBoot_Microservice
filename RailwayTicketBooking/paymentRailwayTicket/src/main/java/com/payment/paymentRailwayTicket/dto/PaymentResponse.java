package com.payment.paymentRailwayTicket.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PaymentResponse {
    private String booking_id;
    private String payment_id;
    private String status;
    private double total_price;
}
