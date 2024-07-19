package com.neoteric.javatdd.busTicket.service;

import com.neoteric.javatdd.busTicket.model.PassengerDetails;
import com.neoteric.javatdd.busTicket.model.Ticket;

public class Test {
    public static void main(String[] args) {
        RouteService routeService = new RouteService();
        TicketBookingService ticketBookingService = new TicketBookingService();

        PassengerDetails passengerDetails = new PassengerDetails();
        passengerDetails.setFromLocation("hyd");
        passengerDetails.setToLocation("KDD");
        passengerDetails.setNumberOfPeoples(2);
        passengerDetails.setName("Uday");
        passengerDetails.setAge(26);
        passengerDetails.setEmail("Uday@example.com");

        Ticket ticket = ticketBookingService.bookingProcess(passengerDetails, routeService);
        System.out.println(ticket);

        double totalFare = ticketBookingService.calculate(passengerDetails, routeService);
        System.out.println("Total Fare: " + totalFare);
    }

}
