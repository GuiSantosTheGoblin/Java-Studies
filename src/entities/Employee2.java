package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Employee2 {
    private String name;
    private String email;
    private BigDecimal salary;

    public Employee2(){}

    public Employee2(Employee2 employee) {
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.salary = employee.getSalary();
    }

    public Employee2(String name, String email, BigDecimal salary){
        this.name = name;
        this.email = email;
        this.salary = salary;
    }


    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSalary(BigDecimal salary){
        this.salary = salary;
    }


    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public BigDecimal getSalary(){
        return this.salary;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName() + "," + this.getEmail() + "," + this.getEmail());

        return sb.toString();
    }


    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        String path;
        List<Employee2> employees = new ArrayList<>();
        BigDecimal salaryCap;
        char firstLetter;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        path = sc.nextLine();
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            for(String line = br.readLine(); line != null; line = br.readLine()){
                String[] employeeInfo = line.split(",");
                Employee2 employee = new Employee2(employeeInfo[0], employeeInfo[1], new BigDecimal(employeeInfo[2]));
                employees.add(employee);
            }
            
            System.out.print("Enter salary: ");
            salaryCap = new BigDecimal(sc.nextLine());

            Predicate<Employee2> predicate1 = e -> e.getSalary().compareTo(salaryCap) > 0;
            Function<Employee2, String> funtion1 = e -> e.getEmail();
            Comparator<String> comparator1 = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
            
            List<String> emailList = employees.stream()
                .filter(predicate1)
                .map(funtion1)
                .sorted(comparator1)
                .toList();
            
            System.out.println("Email of people whose salary is more than " + salaryCap + ":");
            emailList.forEach(System.out::println);


            firstLetter = 'M';

            Predicate<Employee2> predicate2 = e -> e.getName().charAt(0) == firstLetter;
            Function<Employee2, BigDecimal> function2 = e -> e.getSalary();

            BigDecimal salarySum = employees.stream()
                .filter(predicate2)
                .map(function2)
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y)); //or .reduce(BigDecimal.ZERO, BigDecimal::add)
            
            System.out.println("Sum of salary of people whose name starts with '" + firstLetter + "': " + salarySum);
            
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}