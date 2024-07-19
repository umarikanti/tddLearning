package com.neoteric.javatdd.loan.model;

public class ApplicationForm {
   public String applicationNumber;
   public PersonalDetails personalDetails;
   public CompaneyDetails companeyDetails;

   @Override
   public String toString() {
      return "ApplicationForm{" +
              "applicationNumber='" + applicationNumber + '\'' +
              ", personalDetails=" + personalDetails +
              ", companeyDetails=" + companeyDetails +
              '}';
   }
}
