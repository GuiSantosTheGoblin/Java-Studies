package entities;

public class Pessoa {
    private Integer id;
    private String name;
    private Double salary;

    public Pessoa(){}

    public Pessoa(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getSalary(){
        return this.salary;
    }

    public void updateSalary(double percentage){
        this.salary += this.salary * percentage /  100.0;
    }

    @Override
    public String toString(){
        return String.format("%d, %s, %.2f", this.id, this.name, this.salary);
    }
}