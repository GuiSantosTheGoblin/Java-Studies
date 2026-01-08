package entities;

import java.time.LocalDate;

public class HourContract {
    private LocalDate date;
    private Double valuePerHour;
    private Integer hours;


    public HourContract(){}

    public HourContract(LocalDate date, double valuePerHour, int hours){
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public void setDate(LocalDate date){
        this.date =  date;
    }

    public void setValuePerHour(double valuePerHour){
        this.valuePerHour = valuePerHour;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public double getValuePerHour(){
        return this.valuePerHour;
    }

    public int getHours(){
        return this.hours;
    }

    public double totalValue(){
        return this.valuePerHour * this.hours;
    }
}