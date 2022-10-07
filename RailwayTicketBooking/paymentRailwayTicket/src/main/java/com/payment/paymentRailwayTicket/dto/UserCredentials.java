package com.payment.paymentRailwayTicket.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Component
public class UserCredentials {

    @Id
    private int id;
    private String name;
    private String password;
    private double balance;
    private String role;

}
