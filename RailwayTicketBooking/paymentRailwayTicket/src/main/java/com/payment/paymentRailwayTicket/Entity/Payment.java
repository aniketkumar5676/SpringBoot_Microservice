package com.payment.paymentRailwayTicket.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Payment {
    @Id
    private String payment_id;
    private String booking_id;
    private String userId;
    private String payment_date;
    private String status;
    private double total_price;
}
