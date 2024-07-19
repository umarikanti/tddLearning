package com.neoteric.javatdd.loan.model;

public class LoanDetails {
    public  double approvedAmount;
    public  double emiMonthly;
    public  double numberOfMonths;

    public  String loanNUmber;

    public double annualInterestRate;

    @Override
    public String toString() {
        return "LoanDetails{" +
                "approvedAmount=" + approvedAmount +
                ", emiMonthly=" + emiMonthly +
                ", numberOfMonths=" + numberOfMonths +
                ", loanNUmber='" + loanNUmber + '\'' +
                ", annualInterestRate=" + annualInterestRate +
                '}';
    }
}
