public class Mortgage_Calculator_Main {

    //Object Oriented Programming:
    public static void main(String[] args) {

       //Principal: the amount of money we want to borrow
       int principal = (int) Console.readNumber("Principal:", 1000, 1_000_000);
       float annualInterest = (float) Console.readNumber("Annual Interest Rate:", 1, 30);
       byte years = (byte) Console.readNumber("Period (Years):", 1, 30);

       var calculator = new MortgageCalculator(principal, annualInterest, years);
       var report = new MortgageReport(calculator);
       report.printMortgage();
       report.printPaymentSchedule();
    }

}
