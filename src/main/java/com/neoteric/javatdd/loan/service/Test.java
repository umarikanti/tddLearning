package com.neoteric.javatdd.loan.service;

import com.neoteric.javatdd.loan.model.ApplicationForm;
import com.neoteric.javatdd.loan.model.LoanDetails;
import com.neoteric.javatdd.loan.model.PersonalDetails;

public class Test {
    public static void main(String[] args) {
        ApplicationForm  applicationForm = new ApplicationForm();
        PersonalDetails  personalDetails = new PersonalDetails();
        LoanService loanService = new LoanService();


        personalDetails.monthlyIncome = 80000;
        personalDetails.loanAmountRequested = 200000;
        personalDetails.monthlyExpenses = 60000;
        personalDetails.requestedMonths = 18;

        applicationForm.personalDetails = personalDetails;

//
        LoanDetails loanDetails = loanService.approvedLoanDetails(applicationForm);
        System.out.println(loanDetails);


//        String  loan = loanService.loanApproved(applicationForm);
//System.out.println(loan);
//
        String result = loanService.processLoan(applicationForm);
        System.out.println(result);


    }
}
