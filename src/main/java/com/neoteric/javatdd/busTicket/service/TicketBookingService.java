package com.neoteric.javatdd.busTicket.service;

import com.neoteric.javatdd.busTicket.model.Route;
import com.neoteric.javatdd.busTicket.model.Ticket;
import com.neoteric.javatdd.busTicket.model.PassengerDetails;

import java.util.List;

public class TicketBookingService {
    public Route selectedRoute(PassengerDetails passengerDetails, RouteService routeService) {
        List<Route> routes = routeService.routeList();

        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            if (route.getFromLocation().equalsIgnoreCase(passengerDetails.getFromLocation()) &&
                    route.getToLocation().equalsIgnoreCase(passengerDetails.getToLocation())) {

                System.out.println(route);
                return route;
            }
        }


        return null; // Return null if no matching route is found
    }

    public double calculate(PassengerDetails personalDetails, RouteService routeService){

        Route route = selectedRoute(personalDetails, routeService);
        if (route == null) {
            System.out.println("No route found for the given locations.");
        }
        double distance = route.getDistance()/80;
        System.out.println("travel distance in hours : "+distance );
        return personalDetails.getNumberOfPeoples() * route.getPrice();
    }



    public Ticket bookingProcess(PassengerDetails passengerDetails, RouteService routeService) {
        Route route = selectedRoute(passengerDetails, routeService);
        if (route == null) {
            System.out.println("No route found for the given locations.");
        }

        Ticket ticket = new Ticket();
        ticket.setPassengerDetails(passengerDetails);
        ticket.setRoute(route);

        return ticket;
    }

}

