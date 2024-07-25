package com.neoteric.javatdd.phonepay.service;


import com.neoteric.javatdd.phonepay.model.BankDetails;
import com.neoteric.javatdd.phonepay.model.UserDetails;

public class RegistionService {


   public String Otpregistation(UserDetails userDetails, BankDetails bankDetails){
        if(userDetails.phoneNumber.equals(bankDetails.phoneNumber)){
            System.out.println(" your otp is genarated  your otp is: ");
            return "1234";
        }
        return "enter valid number";
    }
}
