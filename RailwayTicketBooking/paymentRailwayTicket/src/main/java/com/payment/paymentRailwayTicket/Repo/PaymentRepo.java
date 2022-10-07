package com.payment.paymentRailwayTicket.Repo;

import com.payment.paymentRailwayTicket.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
    List<Payment> findByUserId(String userId);
}
