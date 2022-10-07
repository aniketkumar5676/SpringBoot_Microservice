package com.book.bookRailwayTicket.repo;

import com.book.bookRailwayTicket.Entity.BookTickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookTicketsRepo extends JpaRepository<BookTickets,Integer> {
      List<BookTickets> findByUserId(String user);
}
