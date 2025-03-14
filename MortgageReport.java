import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    //Initialize calculator through the MortgageReport constructor
    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }


    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = currency.format(mortgage);
        System.out.println("\nMORTGAGE\n________");
        System.out.print("Monthly Payments: " + formattedMortgage + "\n");
    }


    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE\n________________\n");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
        }
}
