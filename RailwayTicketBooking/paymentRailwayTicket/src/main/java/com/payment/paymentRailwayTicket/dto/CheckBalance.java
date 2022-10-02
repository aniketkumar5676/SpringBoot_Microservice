package com.payment.paymentRailwayTicket.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CheckBalance {
    private String user;
    private double total_price;
}
