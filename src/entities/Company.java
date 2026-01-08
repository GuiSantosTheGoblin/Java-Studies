package entities;

import java.math.BigDecimal;

public class Company extends TaxPayer {
    private Integer numberOfEmployees;

    public Company(String name, BigDecimal anualIncome, int numberOfEmployees){
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees(){
        return this.numberOfEmployees;
    }

    @Override
    public BigDecimal tax(){
        BigDecimal taxRate;
        BigDecimal tax;

        if (this.numberOfEmployees > 10){
            taxRate = new BigDecimal(".14");
        } else {
            taxRate = new BigDecimal(".16");
        }

        tax = this.getAnualIncome().multiply(taxRate);
        return tax;
    }
}
