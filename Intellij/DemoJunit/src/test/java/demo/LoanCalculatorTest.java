package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCalculatorTest {

    @Test
    void year_5() {
        int year= 5;
        double amount = 2000000;
        boolean isYouth = true;
        boolean isMarried = false;
        double expected = 5.0-1.0;
        double loan = LoanCalculator.calculateInterestRate(year, amount, isYouth, isMarried);
        assertEquals(expected, loan);
    }

    @Test
    void year_15() {
        int year= 15;
        double amount = 2000000;
        boolean isYouth = false;
        boolean isMarried = true;
        double expected = 5.0-0.5-0.5;
        double loan = LoanCalculator.calculateInterestRate(year, amount, isYouth, isMarried);
        assertEquals(expected, loan);
    }

    @Test
    void year_25() {
        int year= 25;
        double amount = 2000000;
        boolean isYouth = true;
        boolean isMarried = true;
        double expected = 5.0-1.0-1.0-0.5;
        double loan = LoanCalculator.calculateInterestRate(year, amount, isYouth, isMarried);
        assertEquals(expected, loan);
    }

}