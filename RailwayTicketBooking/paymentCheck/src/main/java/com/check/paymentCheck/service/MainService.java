package com.check.paymentCheck.service;

import com.check.paymentCheck.ExceptionHandler.NotFound;
import com.check.paymentCheck.dto.BalanceResponse;
import com.check.paymentCheck.dto.CheckBalance;
import com.check.paymentCheck.dto.UserCredentials;
import com.check.paymentCheck.repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    UserCredentialsRepo userCredentialsRepo;
    @Autowired
    BalanceResponse balanceResponse;

    public BalanceResponse checkBalance(CheckBalance checkBalance) throws NotFound {
        UserCredentials user = userCredentialsRepo.findAllByName(checkBalance.getUser());

        if(user.getBalance() > checkBalance.getTotal_price())
        {
            userCredentialsRepo.save(UserCredentials.build(user.getId(),
                    user.getName(), user.getPassword(),
                    user.getBalance()- checkBalance.getTotal_price()));
                     balanceResponse.setMessage("Success");
        }else{
                    balanceResponse.setMessage("Failed");

        }
        return  balanceResponse;
    }
}
