package com.neoteric.javatdd.loan.service;

import com.neoteric.javatdd.loan.model.ApplicationForm;
import com.neoteric.javatdd.loan.model.LoanDetails;
import com.neoteric.javatdd.loan.model.PersonalDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceTest {

    LoanService loanService;
    ApplicationForm applicationForm;

    @BeforeEach
    void setUp() {
        loanService = new LoanService();
        applicationForm = new ApplicationForm();
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.monthlyIncome = 90000;
        personalDetails.loanAmountRequested = 400000;
        personalDetails.monthlyExpenses = 60000;
        personalDetails.requestedMonths = 18;
        applicationForm.personalDetails = personalDetails;
    }

    @Test
    public void testIsLoanApproved_WithEqualIncomeAndExpenses_ReturnsFalse() {
        applicationForm.personalDetails.monthlyIncome = 50000;
        applicationForm.personalDetails.monthlyExpenses = 50000;

        boolean result = loanService.isLoanApproved(applicationForm);

        Assertions.assertFalse(result);
    }

    @Test
    public void testIsLoanApproved_WithDifferentIncomeAndExpenses_ReturnsTrue() {
        boolean result = loanService.isLoanApproved(applicationForm);

        Assertions.assertTrue(result);
    }

    @Test
    public void testApprovedDetails_WhenLoanIsApproved_CalculatesLoanDetails() {
        LoanDetails loanDetails = loanService.approvedLoanDetails(applicationForm);

        Assertions.assertNotNull(loanDetails);
        Assertions.assertEquals(300000.0, loanDetails.approvedAmount);
        Assertions.assertEquals(24, loanDetails.numberOfMonths);
        Assertions.assertEquals(9.5, loanDetails.annualInterestRate);
        Assertions.assertNotNull(loanDetails.loanNUmber);
    }

    @Test
    public void testLoanApproved_WhenLoanIsApproved_CalculatesEMI() {
        String result = loanService.loanApproved(applicationForm);

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.contains("For 18.0 months"));
    }
}

