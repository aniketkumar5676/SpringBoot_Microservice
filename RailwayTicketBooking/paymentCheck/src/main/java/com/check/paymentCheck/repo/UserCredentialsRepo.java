package com.check.paymentCheck.repo;

import com.check.paymentCheck.dto.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials,Integer> {
    UserCredentials findAllByName(String user);
}
