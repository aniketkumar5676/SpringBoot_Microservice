package com.book.bookRailwayTicket.repo;

import com.book.bookRailwayTicket.Entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials,Integer> {
    UserCredentials findByName(String username);
}
