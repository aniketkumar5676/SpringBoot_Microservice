package com.book.bookRailwayTicket.repo;

import com.book.bookRailwayTicket.Entity.Trains;
import com.book.bookRailwayTicket.Entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainsRepo extends JpaRepository<Trains,Integer> {
    Trains findAllByTrainno(int trainNo);
}
