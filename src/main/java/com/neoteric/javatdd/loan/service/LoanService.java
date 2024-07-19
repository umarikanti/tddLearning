package com.neoteric.javatdd.loan.service;

import com.neoteric.javatdd.loan.model.ApplicationForm;
import com.neoteric.javatdd.loan.model.LoanDetails;
import com.neoteric.javatdd.loan.model.PersonalDetails;
import java.util.UUID;

public class LoanService {

    public double amount;

    public boolean isLoanApproved(ApplicationForm applicationForm) {
        if (applicationForm.personalDetails.monthlyIncome
                == applicationForm.personalDetails.monthlyExpenses) {
            System.out.println("your application is reject ");
            return false;
        } else {
            applicationForm.applicationNumber = UUID.randomUUID().toString();
            System.out.println("your application is accepted" +
                    applicationForm.applicationNumber);
        }
        return true;
    }


    public LoanDetails approvedLoanDetails(ApplicationForm applicationForm) {
        LoanDetails loanDetails = new LoanDetails();
        if (isLoanApproved(applicationForm)) {
            amount = applicationForm.personalDetails.monthlyIncome - applicationForm.personalDetails.monthlyExpenses;
            loanDetails.approvedAmount = amount * 10;

            loanDetails.numberOfMonths = 24;
            loanDetails.annualInterestRate = 9.5;
            loanDetails.loanNUmber = UUID.randomUUID().toString();

            double monthlyInterestRate = loanDetails.annualInterestRate / 12 / 100;

            double emi = (loanDetails.approvedAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanDetails.numberOfMonths)) /
                    (Math.pow(1 + monthlyInterestRate, loanDetails.numberOfMonths) - 1);

            loanDetails.emiMonthly = emi;
        }
        return loanDetails;
    }

    public String loanApproved(ApplicationForm applicationForm) {
        amount = applicationForm.personalDetails.monthlyIncome - applicationForm.personalDetails.monthlyExpenses;

        LoanDetails loanDetails = approvedLoanDetails(applicationForm);

        double monthlyInterestRate = loanDetails.annualInterestRate / 12 / 100;
        double totalAmount = loanDetails.approvedAmount + (monthlyInterestRate * applicationForm.personalDetails.requestedMonths);

        double emi = (loanDetails.approvedAmount * monthlyInterestRate
                * Math.pow(1 + monthlyInterestRate, applicationForm.personalDetails.requestedMonths)) /
                (Math.pow(1 + monthlyInterestRate, applicationForm.personalDetails.requestedMonths) - 1);

        if (applicationForm.personalDetails.loanAmountRequested<=amount*10) {
            return "For " + applicationForm.personalDetails.requestedMonths +
                    " months, your EMI for the approved amount of " +
                    loanDetails.approvedAmount + " will be: " + emi +
                    " Total amount with interest: " + totalAmount;
        } else {
            System.out.println("Your loan is rejected because requested loan greater then.");
            return "The requested number of months is not available.";
        }
    }


    public String processLoan(ApplicationForm applicationForm) {
        if (!isLoanApproved(applicationForm)) {
            return "Loan is rejected due to equal income and expenses.";
        }

        return loanApproved(applicationForm);
    }
}


