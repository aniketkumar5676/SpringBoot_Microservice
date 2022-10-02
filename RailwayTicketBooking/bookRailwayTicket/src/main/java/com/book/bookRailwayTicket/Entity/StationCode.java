package com.book.bookRailwayTicket.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationCode {
    @Id
    @GeneratedValue
    private int sno;
    private String station_name;
    private String station_code;
 }
