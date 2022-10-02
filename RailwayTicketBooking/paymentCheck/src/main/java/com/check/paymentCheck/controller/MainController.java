package com.check.paymentCheck.controller;

import com.check.paymentCheck.ExceptionHandler.NotFound;
import com.check.paymentCheck.dto.BalanceResponse;
import com.check.paymentCheck.dto.CheckBalance;
import com.check.paymentCheck.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @PostMapping("/check")
    public BalanceResponse checkBalance(@RequestBody CheckBalance checkBalance) throws NotFound {
        return mainService.checkBalance(checkBalance);
    }


}
