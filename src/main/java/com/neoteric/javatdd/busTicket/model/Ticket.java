package com.neoteric.javatdd.busTicket.model;

import lombok.Data;

@Data
public class Ticket {
    private PassengerDetails passengerDetails;
    private  Route route;
}
