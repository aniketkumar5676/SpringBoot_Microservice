package com.payment.paymentRailwayTicket.Controller;

import com.payment.paymentRailwayTicket.Entity.Payment;
import com.payment.paymentRailwayTicket.Service.PaymentService;
import com.payment.paymentRailwayTicket.dto.PaymentRequest;
import com.payment.paymentRailwayTicket.dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public PaymentResponse doPayment (@RequestBody PaymentRequest paymentRequest)
    {
        return paymentService.doPayment(paymentRequest);
    }

    @GetMapping("/paymentHistory")
    public List<Payment> paymentHistory(){
        return paymentService.paymentHistory();
    }

}
