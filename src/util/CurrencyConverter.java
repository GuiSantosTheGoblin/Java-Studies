package util;

public class CurrencyConverter {

  public static final double IOF = 0.06;

  public static double dollarPurchase(double dollarPice, double dollarAmount){
    return (dollarPice * dollarAmount) + (dollarPice * dollarAmount * IOF);
  }
}