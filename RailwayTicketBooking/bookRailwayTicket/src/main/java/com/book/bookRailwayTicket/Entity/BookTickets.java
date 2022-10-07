package com.book.bookRailwayTicket.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookTickets {

    @Id
    @GeneratedValue
    private int bookingno;
    private String bookingId;
    private String name;
    private String userId;
    private int age;
    private int trainNo;
    private String origin;
    private String destination;
    private String bookingDate;

    @Enumerated(EnumType.STRING)
    private Status status;
}
