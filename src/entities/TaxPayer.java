package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class TaxPayer {
    private String name;
    private BigDecimal anualIncome;

    public TaxPayer(String name, BigDecimal anualIncome){
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public String getName(){
        return this.name;
    }
    public BigDecimal getAnualIncome(){
        return this.anualIncome;
    }

    public abstract BigDecimal tax();

    public String toString(){
        StringBuilder sb =  new StringBuilder();
        sb.append(name);
        sb.append(": $ ");
        sb.append(this.tax().setScale(2, RoundingMode.FLOOR));

        return sb.toString();
    }
}