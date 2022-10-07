package com.payment.paymentRailwayTicket.Repo;

import com.payment.paymentRailwayTicket.dto.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials,Integer> {
    UserCredentials findByName(String username);
}
