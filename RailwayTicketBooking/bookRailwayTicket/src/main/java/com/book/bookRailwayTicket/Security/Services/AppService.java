package com.book.bookRailwayTicket.Security.Services;

import com.book.bookRailwayTicket.Entity.*;
import com.book.bookRailwayTicket.ExceptionHandler.NotFound;
import com.book.bookRailwayTicket.dto.*;
import com.book.bookRailwayTicket.repo.BookTicketsRepo;
import com.book.bookRailwayTicket.repo.StationCodeRepo;
import com.book.bookRailwayTicket.repo.TrainsRepo;
import com.book.bookRailwayTicket.repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@Service
public class AppService implements UserDetailsService {

    @Autowired
    UserCredentialsRepo userCredentialsRepo;
    @Autowired
    TrainsRepo trainsRepo;
    @Autowired
    DisplayTicket displayTicket;
    @Autowired
    PaymentRequest paymentRequest;
    @Autowired
    StationCodeRepo stationCodeRepo;
    @Autowired
    BookTicketsRepo bookTicketsRepo;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ActiveUser activeUser;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = userCredentialsRepo.findByName(username);
         return new org.springframework.security.core.userdetails.User(userCredentials.getName(),userCredentials.getPassword(), Collections
                .emptyList());
    }

    public DisplayTicket bookTicket(Ticketinfo ticketinfo) throws NotFound {

        Trains trains = trainsRepo.findAllByTrainno(ticketinfo.getTrainNo());
        Payment payment = ticketinfo.getPayment();

       if(trains!=null)
        {
            if(trains.getDestination().equals(ticketinfo.getDestination()) && trains.getOrigin().equals(ticketinfo.getOrigin()))
            {

             paymentRequest.setBooking_id(String.valueOf(UUID.randomUUID()));
             paymentRequest.setPrice(payment.getPrice());
             paymentRequest.setUser(ticketinfo.getUser());

             PaymentResponse paymentResponse = restTemplate.postForObject("http://RAILWAYPAYMENT/payment/payment",paymentRequest,
                                                                                     PaymentResponse.class);

             assert paymentResponse != null;

                BookTickets bookTickets =new BookTickets();

                bookTickets.setUserId(activeUser.getUser());
                bookTickets.setBookingId(paymentResponse.getBooking_id());
                bookTickets.setName(ticketinfo.getName());
                bookTickets.setAge(ticketinfo.getAge());
                bookTickets.setTrainNo(ticketinfo.getTrainNo());
                bookTickets.setOrigin(ticketinfo.getOrigin());
                bookTickets.setDestination(ticketinfo.getDestination());
                bookTickets.setBookingDate(String.valueOf(LocalDate.now()));

            if(paymentResponse.getStatus().equals("Success"))
             {
                 displayTicket.setStatus(Status.BOOKED.toString());
                 bookTickets.setStatus(Status.BOOKED);
                 bookTicketsRepo.save(bookTickets);

             }else{
                 displayTicket.setStatus("Failed Due to Low Balance");
                 bookTickets.setStatus(Status.NOT_BOOKED);
                 bookTicketsRepo.save(bookTickets);
             }

              displayTicket.setTicketinfo(ticketinfo);
              displayTicket.setBooking_id(paymentResponse.getBooking_id());
              displayTicket.setTotal_price(paymentResponse.getTotal_price());

             return displayTicket;


            }else{
                throw  new NotFound("Train Not Touching those Stations");
            }
        }else
        {
            throw  new NotFound("Invalid Train No " + ticketinfo.getTrainNo());
        }

    }

    public List<StationCode> station() {
        return stationCodeRepo.findAll();
    }

    public List<Trains> trainList() {
        return trainsRepo.findAll();
    }

    public List<BookTickets> bookingHistory() throws NotFound {

    UserCredentials userCredentials=  userCredentialsRepo.findByName(activeUser.getUser());

        if(userCredentials.getRole().equals("admin"))
        {
            return bookTicketsRepo.findAll();
        }else {

          if(bookTicketsRepo.findByUserId(activeUser.getUser()).isEmpty())
          {
              throw new NotFound("No Booking found for User  " + activeUser.getUser());
          }

            return bookTicketsRepo.findByUserId(activeUser.getUser());
        }

    }

    public Map balance() {

      UserCredentials userCredentials=  userCredentialsRepo.findByName(activeUser.getUser());
      Map<String, Object> userMap = new HashMap<>();

      if(userCredentials.getRole().equals("admin"))
      {
          List<UserCredentials> userList =userCredentialsRepo.findAll();
          userList.forEach(user -> userMap.put(user.getName(),user.getBalance()));
          return userMap;

      }
        userMap.put(userCredentials.getName(),userCredentials.getBalance());
      return userMap;
    }
}
