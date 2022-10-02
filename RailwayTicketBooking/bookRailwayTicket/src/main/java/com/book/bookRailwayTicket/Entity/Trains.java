package com.book.bookRailwayTicket.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Trains {

    @Id
    private int trainno;
    private String trainname;
    private String destination;
    private String origin;

}

