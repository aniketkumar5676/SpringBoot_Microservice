package com.book.bookRailwayTicket.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticketinfo {

    @NotBlank
    private String name;
    @Min(12)
    @Max(150)
    private int age;
    @NotNull
    private int trainNo;
    @NotBlank
    private String origin;
    @NotBlank
    private String destination;
    private String user;
    private Payment payment;
}
