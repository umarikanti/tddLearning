package com.neoteric.javatdd.loan.model;

import com.neoteric.javatdd.loan.model.Address;

public class PersonalDetails {
   public String name;
  public   int age;
   public String employmentStatus;
  public   double monthlyIncome;
   public double monthlyExpenses;
   public double loanAmountRequested;

   public Address personalAddress;

   public double requestedMonths;

    @Override
    public String toString() {
        return "PersonalDetails{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", monthlyExpenses=" + monthlyExpenses +
                ", loanAmountRequested=" + loanAmountRequested +
                ", personalAddress=" + personalAddress +
                ", requestedMonths=" + requestedMonths +
                '}';
    }
}
