package com.neoteric.javatdd.busTicket.model;


import lombok.Data;

@Data
public class PassengerDetails {
    private String name;
    private int age;
    private String email;
    private String fromLocation;
    private String toLocation;
    private  int numberOfPeoples;
}
