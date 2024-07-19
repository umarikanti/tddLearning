package com.neoteric.javatdd.busTicket.service;

import com.neoteric.javatdd.busTicket.model.PassengerDetails;
import com.neoteric.javatdd.busTicket.model.Route;
import com.neoteric.javatdd.busTicket.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 public  class TicketBookingServiceTest {
    private TicketBookingService ticketBookingService;
    private RouteService routeService;
    private PassengerDetails passengerDetails;

     @BeforeEach
     public void setUp() {
         ticketBookingService = new TicketBookingService();
         routeService = new RouteService() {

             public List<Route> routeList() {
                 Route route1 = new Route();
                 route1.setFromLocation("hyd");
                 route1.setToLocation("KDD");
                 route1.setDistance(180);
                 route1.setPrice(320);
                 route1.setTravelDate(new Date());

                 Route route2 = new Route();
                 route2.setFromLocation("hyd");
                 route2.setToLocation("KHMM");
                 route2.setDistance(210);
                 route2.setPrice(350);
                 route2.setTravelDate(new Date());

                 List<Route> routeList = new ArrayList<>();
                 routeList.add(route1);
                 routeList.add(route2);
                 return routeList;
             }
         };

         passengerDetails = new PassengerDetails();
         passengerDetails.setFromLocation("hyd");
         passengerDetails.setToLocation("KDD");
         passengerDetails.setNumberOfPeoples(3);
         passengerDetails.setName("John Doe");
         passengerDetails.setAge(30);
         passengerDetails.setEmail("johndoe@example.com");
     }

     @Test
     public void testSelectedRoute() {
         Route route = ticketBookingService.selectedRoute(passengerDetails, routeService);
         assertNotNull(route);
         assertEquals("hyd", route.getFromLocation());
         assertEquals("KDD", route.getToLocation());
     }

     @Test
     public void testSelectedRouteNotFound() {
         passengerDetails.setToLocation("Unknown");
         Route route = ticketBookingService.selectedRoute(passengerDetails, routeService);
         assertNull(route);
     }

     @Test
     public void testCalculate() {
         double totalFare = ticketBookingService.calculate(passengerDetails, routeService);
         assertEquals(960.0, totalFare);
     }

     @Test
     public void testCalculateRouteNotFound() {
         passengerDetails.setToLocation("Unknown");
         Exception exception = assertThrows(NullPointerException.class, () -> {
             ticketBookingService.calculate(passengerDetails, routeService);
         });
         assertEquals("No route found for the given locations.", exception.getMessage());
     }

     @Test
     public void testBookingProcess() {
         Ticket ticket = ticketBookingService.bookingProcess(passengerDetails, routeService);
         assertNotNull(ticket);
         assertEquals(passengerDetails, ticket.getPassengerDetails());
         assertEquals("hyd", ticket.getRoute().getFromLocation());
         assertEquals("KDD", ticket.getRoute().getToLocation());
     }

     @Test
     public void testBookingProcessRouteNotFound() {
         passengerDetails.setToLocation("Unknown");
         Exception exception = assertThrows(NullPointerException.class, () -> {
             ticketBookingService.bookingProcess(passengerDetails, routeService);
         });
         assertEquals("No route found for the given locations.", exception.getMessage());
     }
}

