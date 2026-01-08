package entities;


public class BankAccount {

  public static final double TAX = 5.00;

  private int id;
  private String holder;
  private double balance;

  public BankAccount(int id, String holder){
    this.id = id;
    this.holder = holder;
  }

  public BankAccount(int id, String holder, double initialDeposit){
    this.id = id;
    this.holder = holder;
    this.deposit(initialDeposit);
  }

  public int getId(){
    return this.id;
  }

  public String getHolder(){
    return this.holder;
  }

  public double getBalance(){
    return this.balance;
  }

  public void setHolder(String holder){
    this.holder = holder;
  }

  public void deposit(double amount){
    this.balance += amount;
  }

  public void withdraw(double amount){
    this.balance -= (amount + TAX);
  }

  public String toString(){
    return 
    "Account " + 
    this.id +
    ", Holder: " +
    this.holder +
    ", Balance: $ " +
    String.format("%.2f", balance);
  }
}