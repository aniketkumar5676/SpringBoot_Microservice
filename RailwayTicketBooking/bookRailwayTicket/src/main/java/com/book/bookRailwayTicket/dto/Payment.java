package com.book.bookRailwayTicket.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Payment {
    @NotBlank
    private double price;
    @NotBlank
    private String paymentMethod;
}
