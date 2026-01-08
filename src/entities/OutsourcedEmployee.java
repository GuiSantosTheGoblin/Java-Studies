package entities;

public class OutsourcedEmployee extends Employee {
    private Double additionalCharge;

    private final int bonusRate = 110;

    public OutsourcedEmployee(){}

    public OutsourcedEmployee(String name, int hours, double valuePerHour, double additionalCharge){
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment(){
        return super.payment() + (additionalCharge * bonusRate / 100.00);
    }
}