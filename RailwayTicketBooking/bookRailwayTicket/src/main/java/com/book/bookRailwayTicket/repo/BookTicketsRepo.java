package com.book.bookRailwayTicket.repo;

import com.book.bookRailwayTicket.Entity.BookTickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTicketsRepo extends JpaRepository<BookTickets,Integer> {
}
