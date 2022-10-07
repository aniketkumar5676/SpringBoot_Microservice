package com.book.bookRailwayTicket.controller;

import com.book.bookRailwayTicket.Entity.BookTickets;
import com.book.bookRailwayTicket.Entity.StationCode;
import com.book.bookRailwayTicket.Entity.Trains;
import com.book.bookRailwayTicket.ExceptionHandler.NotFound;
import com.book.bookRailwayTicket.Security.Services.AppService;
import com.book.bookRailwayTicket.dto.*;
import com.book.bookRailwayTicket.Util.JwtUtil;
import com.book.bookRailwayTicket.repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class BookingController {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserCredentialsRepo userCredentialsRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    AppService appService;

    @Autowired
    ActiveUser activeUser;


    @PostMapping("/authenticate")
    public String generateToken(@RequestBody UserInput userInput) throws Exception {
        // validations
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userInput.getName(), userInput.getPassword()));
        }
        catch (Exception e) {
            throw new Exception("Invalid username and password"+ e.getMessage());
        }
        return jwtUtil.generateToken(userInput.getName());
    }



    @PostMapping("/bookTickets")
    public DisplayTicket bookTicket(@RequestBody @Valid Ticketinfo ticketinfo) throws NotFound {
        ticketinfo.setUser(activeUser.getUser());
                return appService.bookTicket(ticketinfo);
    }


  @GetMapping("/station")
    public List<StationCode> station(){
        return appService.station();
  }


    @GetMapping("/trainList")
    public List<Trains> trainList(){
        return appService.trainList();
    }

    @GetMapping("/bookingHistory")
    public List<BookTickets> bookingHistory() throws NotFound {
        return appService.bookingHistory();
    }

    @GetMapping("/balance")
    public Map balance(){
        return appService.balance();
    }

}