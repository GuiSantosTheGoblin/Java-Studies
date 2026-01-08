package entities;

import java.math.BigDecimal;

public class Individual extends TaxPayer {
    private BigDecimal healthExpenditures;

    public Individual(String name, BigDecimal anualIncome, BigDecimal healthExpenditures){
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public BigDecimal getHealthExpenditures(){
        return this.healthExpenditures;
    }

    @Override
    public BigDecimal tax(){
        BigDecimal taxRate;
        BigDecimal tax;

        if (this.getAnualIncome().compareTo(new BigDecimal("20000.00")) < 0){
            taxRate = new BigDecimal(".15");
        } else {
            taxRate = new BigDecimal(".25");
        }
        
        tax = this.getAnualIncome().multiply(taxRate);
        return tax.subtract(this.healthExpenditures.multiply(new BigDecimal(".5")));
    }
}