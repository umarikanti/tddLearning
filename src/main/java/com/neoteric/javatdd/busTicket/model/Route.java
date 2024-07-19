package com.neoteric.javatdd.busTicket.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Route {
    private String fromLocation;
    private String toLocation;
    private double distance;
    private double price;
    private Date travelDate;
    private List<Bus> busList;

}
