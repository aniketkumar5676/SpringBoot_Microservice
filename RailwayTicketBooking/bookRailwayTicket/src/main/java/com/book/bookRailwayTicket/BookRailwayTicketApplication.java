package com.book.bookRailwayTicket;

import com.book.bookRailwayTicket.Entity.StationCode;
import com.book.bookRailwayTicket.Entity.Trains;
import com.book.bookRailwayTicket.Entity.UserCredentials;
import com.book.bookRailwayTicket.repo.StationCodeRepo;
import com.book.bookRailwayTicket.repo.TrainsRepo;
import com.book.bookRailwayTicket.repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
public class BookRailwayTicketApplication {

	@Autowired
	UserCredentialsRepo userCredentialsRepo;
    @Autowired
	TrainsRepo trainsRepo;
    @Autowired
	StationCodeRepo stationCodeRepo;

	@PostConstruct
	public void addCredentials() {
		List<UserCredentials> userCredentialsList = Stream.of(
				new UserCredentials(1, "Aniket", "aniket",900),
				new UserCredentials(2, "Rahul", "rahul",500),
				new UserCredentials(3, "Satyajeet", "satyajeet",200))
				.collect(Collectors.toList());
		userCredentialsRepo.saveAll(userCredentialsList);

		List<Trains> trainsRepoList = Stream.of(
				       new Trains(12267,"AHMEDABAD AC DURONTO EXP","MUM","ADI"),
				       new Trains(22201,"PURI DURONTO EXPRESS","PURI","SDAH"),
			           new Trains(22204,"SECUNDERABAD VISAKHAPATNAM AC DURONTO EXPRESS","VSKP","SC"),
				       new Trains(12426,"JAMMU TAWI - NEW DELHI RAJDHANI EXPRESS","NDLS","JAT"),
			           new Trains(12019,"HOWRAH - RANCHI SHATABDI EXPRESS","RNC","HWH"),
			           new Trains(12038,"LUDHIANA - NEW DELHI SHATABDI EXPRESS","LDH","NDLS"),
			           new Trains(11077,"PUNE - JAMMU TAWI JHELUM EXPRESS","JAT","PUNE"),
			      	   new Trains(12307,"HOWRAH - JODHPUR SF EXPRESS","HWH","JU")
		               ).collect(Collectors.toList());
		trainsRepo.saveAll(trainsRepoList);

		List<StationCode> stationCodesList = Stream.of(
				new StationCode(1,"Mumbai","MUM"),
				new StationCode(1,"Ahmedabad","ADI"),
				new StationCode(1,"Puri","PURI"),
				new StationCode(1,"Sealdah ","SDAH"),
				new StationCode(1,"Visakhapatnam","VSKP"),
				new StationCode(1,"Secunderabad","SC"),
				new StationCode(1,"Delhi","NDLS"),
				new StationCode(1,"Ludhiana","LDH"),
				new StationCode(1,"Jammu Tawi","JAT"),
				new StationCode(1,"Jodhpur","JU")
		).collect(Collectors.toList());

stationCodeRepo.saveAll(stationCodesList);

	}




	public static void main(String[] args) {
		SpringApplication.run(BookRailwayTicketApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
