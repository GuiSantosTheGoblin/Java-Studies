package entities;

public class Employee {
    private String name;
    private Integer hours;
    private Double valuePerHour;

    public Employee(){}

    public Employee(String name, int hours, double valuePerHour){
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public Double payment(){
        return (double) this.hours * this.valuePerHour;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - $ %.2f", this.name, this.payment()));
        return sb.toString();
    }
}
