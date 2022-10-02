package com.book.bookRailwayTicket.repo;

import com.book.bookRailwayTicket.Entity.StationCode;
import com.book.bookRailwayTicket.Entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationCodeRepo extends JpaRepository<StationCode,Integer> {
}
