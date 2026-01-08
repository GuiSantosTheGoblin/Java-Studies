package model.entities;

import java.math.BigDecimal;

import model.exceptions.InvalidAmountException;

public class Account {
    private Integer number;
    private String holder;
    private BigDecimal balance;
    private BigDecimal withdrawLimit;

    public Account(){}

    public Account(int number, String holder, BigDecimal balance, BigDecimal withdrawLimit){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }
    
    public void withdraw(BigDecimal amount) throws InvalidAmountException{
        if (amount.compareTo(this.withdrawLimit) > 0){
            throw new InvalidAmountException("The amount exceeds withdraw limit");
        }

        if (amount.compareTo(this.balance) > 0){
            throw new InvalidAmountException("Not enough balance");
        }

        this.balance = this.balance.subtract(amount);
    }
    
}
