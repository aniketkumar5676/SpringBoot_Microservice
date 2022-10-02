package com.payment.paymentRailwayTicket.Service;

import com.payment.paymentRailwayTicket.Entity.Payment;
import com.payment.paymentRailwayTicket.Repo.PaymentRepo;
import com.payment.paymentRailwayTicket.dto.BalanceResponse;
import com.payment.paymentRailwayTicket.dto.CheckBalance;
import com.payment.paymentRailwayTicket.dto.PaymentRequest;
import com.payment.paymentRailwayTicket.dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    Payment payment;
    @Autowired
    PaymentResponse paymentResponse;

    @Autowired
    CheckBalance checkBalance;
    @Autowired
    RestTemplate restTemplate;
    public PaymentResponse doPayment(PaymentRequest paymentRequest) {

      payment.setBooking_id(paymentRequest.getBooking_id());
      payment.setPayment_id(String.valueOf(UUID.randomUUID()));
      payment.setPayment_date(String.valueOf(LocalDate.now()));
      payment.setTotal_price(paymentRequest.getPrice()*18/100+paymentRequest.getPrice());


      checkBalance.setUser(paymentRequest.getUser());
      checkBalance.setTotal_price(payment.getTotal_price());

       BalanceResponse balanceResponse = restTemplate.postForObject("http://PAYMENTCHECK/check",checkBalance,BalanceResponse.class);


        assert balanceResponse != null;
        if ((balanceResponse.getMessage().equals("Success"))){

         payment.setStatus("Success");

       }else {
           payment.setStatus("Failed Due to Low Balance");
       }

      paymentRepo.save(payment);

      paymentResponse.setStatus(payment.getStatus());
      paymentResponse.setPayment_id(payment.getPayment_id());
      paymentResponse.setBooking_id(payment.getBooking_id());
      paymentResponse.setTotal_price(payment.getTotal_price());

      return paymentResponse;

    }

    public List<Payment> paymentHistory() {
        return paymentRepo.findAll();
    }
}
