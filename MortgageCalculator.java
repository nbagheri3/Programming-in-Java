public class MortgageCalculator {

    private final static byte MONTH_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    //Calculating the remaining balance after a number of payments
    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments) -
                Math.pow(1 + monthlyInterest, numberOfPaymentsMade)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }


    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    //we want to return a list of numbers(Balance at each month)
    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        // convert getNumberOfPayments() ---> balances.length
        for (short month = 1; month <= balances.length; month++)
            //calculate balance after each month
            //index of first elemnt in arary is zero
            balances[month -1] = calculateBalance(month);
        return balances;
    }
    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTH_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTH_IN_YEAR;
    }

}
