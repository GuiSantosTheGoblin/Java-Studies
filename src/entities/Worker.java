package entities;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import util.WorkerLevel;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(){}

    public Worker(Department department){
        this.department = department;
    }

    public Worker(String name, WorkerLevel level, double baseSalary, Department department){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLevel(WorkerLevel level){
        this.level = level;
    }

    public void setBaseSalary(double baseSalary){
        this.baseSalary = baseSalary;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public String getName(){
        return this.name;
    }

    public WorkerLevel getLevel(){
        return this.level;
    }

    public double getBaseSalary(){
        return this.baseSalary;
    }

    public String getDepartment(){
        return this.department.getName();
    }

    /*public List getContracts(){
        return this.contracts;
    }*/

    public void addContract(HourContract contract){
        this.contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        this.contracts.remove(contract);
    }

    public double showIncome(LocalDate incomeDate){
        double income = this.baseSalary;
        
        for(HourContract contract: contracts){
            if (incomeDate.getYear() == contract.getDate().getYear() 
            && incomeDate.getMonth() == contract.getDate().getMonth()){
                income += contract.totalValue();
            }
        }

        return income;
    }
}
