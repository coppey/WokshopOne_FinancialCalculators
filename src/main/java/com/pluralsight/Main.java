package com.pluralsight;
import java.util.*;


public class Main
{
    public static void main(String[] args)
    {
        //start time 7:12pm - end time 10:23pm
        Scanner sc = new Scanner(System.in);
        //prompt user to use 1/3 calcs
        System.out.println("What would you like to calculate today? ");
        System.out.println("A. Mortgage payments");
        System.out.println("B. Investment Development");
        System.out.println("C. Current Annuity");
        String input = sc.nextLine();


        if(input.equalsIgnoreCase("A"))
        {
            /*
            Mortgage Calc - monthly pay on loan + interest,
            user can enter interest rate
            should display monthly payment and interest paid
            uses compound interest formula
            */

            System.out.println("Please enter the amount you would like to calculate: ");
            double amount = sc.nextDouble();
            System.out.println("What is the interest rate you will be paying: ");
            double rate = sc.nextDouble();
            System.out.println("Please enter the amount of years you would pay this amount: ");
            int years = sc.nextInt();

            // Convert loan term in years to loan term in months
            int time = years * 12;

            //Calculate Monthly payment with method
            double mortgage = morg(amount, rate, years);

            // Calculate the total payment over the life of the loan
            double totalPayment = mortgage * time;

            // Calculate total interest paid
            double totalInterest = totalPayment - amount;

            // Output the results
            System.out.println("Monthly payment: $" + (int)mortgage);
            System.out.println("Total interest paid over the life of the loan: $"+ (int)totalInterest);
            System.out.println("Total payment over the life of the loan: $" + (int)totalPayment);

        } else if (input.equalsIgnoreCase("B"))
        {
                /*
                Investment Calc - calculates the future value of one time deposit
                user should enter deposit amount and interest rate
                should display future value and interest accumulated
                 */

            // Investment Calculation
            System.out.println("Please enter the amount you would like to invest: ");
            double amount = sc.nextDouble();
            System.out.println("What is the interest rate: ");
            double rate = sc.nextDouble();
            System.out.println("How many years will this investment build: ");
            int years = sc.nextInt();

            // Calculate future value of investment
            double futureValue = inve(amount, rate, years);

            // Calculate the Total Interest Accumulated
            double totalInterest = futureValue - amount;

            //Output Results
            System.out.println("Future Value of Investment: $" + (int)futureValue);
            System.out.println("The total interest accumulated is: $" + (int)totalInterest);

        } else if (input.equalsIgnoreCase("C"))
        {
                    /*
                    Annuity Calc - finds the present value of annuity
                    user should be prompted for monthly payout, expected interest rate, and years to pay out user
                    should calculate present day value of that Annuity
                     */
            // Annuity Input
            System.out.println("Please enter the monthly payout amount: ");
            double amount = sc.nextDouble();
            System.out.println("What is the annual interest rate: ");
            double rate = sc.nextDouble();
            System.out.println("How many years will the payout last: ");
            int years = sc.nextInt();

            // Calculate present value of the annuity
            double annuity = annu(amount, rate, years);

            //Output Results
            System.out.println("Present Value of Annuity: $" + (int)annuity);

        } else
        {
            System.out.println("Invalid input ");
        }

    }



    //Mortgage Method - Monthly Basis
    public static double morg(double amount, double rate, int years)
    {
        // Convert annual interest rate to monthly interest rate
        double rate12 = rate / 100 / 12;

        // Convert loan term in years to loan term in months within method this time, tried without, but it did not work
        int time = years * 12;

        // Calculate the monthly payment using the formula:
        // M = P [ r(1+r)^n ] / [ (1+r)^n – 1 ]
        double monthlyPayment = (amount * rate12 * Math.pow(1 + rate12, time)) / (Math.pow(1 + rate12, time) - 1);


        return monthlyPayment;
    }

    // Investment Method - Compound Interest Formula
    public static double inve(double amount, double rate, int years)
    {
        // Annual compounding, n = 1
        double futureValue = amount * Math.pow(1 + (rate / 100), years);
        return futureValue;
    }

    // Annuity Method - Present Value of Annuity Formula
    public static double annu(double payment, double rate, int years)
    {
        // Convert annual interest rate to monthly interest rate
        double rate12 = rate / 100 / 12;

        // Convert loan term in years to loan term in months
        int time = years * 12;

        // Calculate the present value of the annuity
        double presentValue = payment * (1 - (1 / Math.pow(1 + rate12, time))) / rate12;

        return presentValue;
    }
}