package com.payment.paymentRailwayTicket.Repo;

import com.payment.paymentRailwayTicket.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
}
