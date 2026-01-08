package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Comparator;

public class Product2 /*implements Comparable<Product2>*/ {
    private String name;
    private BigDecimal price;

    public Product2(){}

    public Product2(Product2 other){
        this.name = other.getName();
        this.price = other.getPrice();
    }

    public Product2(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    @Override
    public String toString(){
        return this.name + ", " + this.price;
    }

    /*@Override
    public int compareTo(Product2 other){
        return this.getName().toUpperCase().compareTo(other.getName().toUpperCase());
    }*/
   

    public static void main (String[] arg) {
        String path;
        List<Product2> productList = new ArrayList<>();
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        path = sc.nextLine();
        sc.close();
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String line = br.readLine(); line != null; line = br.readLine()){
                String[] productInfo = line.split(",");
                Product2 product = new Product2(productInfo[0], new BigDecimal(productInfo[1]));
                productList.add(product);
            }
            
            Function<Product2, BigDecimal> function1 = p -> p.getPrice();
            
            BigDecimal avg = productList.stream()
			          .map(function1)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                //ou .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
                .divide(new BigDecimal(productList.size()), 2, RoundingMode.HALF_UP);
            
            System.out.println("Average price: " + avg);
            

            Predicate<Product2> predicate = p -> p.getPrice().compareTo(avg) < 0;
            Function<Product2, String> function2 = p -> p.getName();
            Comparator<String> comparator = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
            
            List<String> belowAvaragePriceList = productList.stream()
                .filter(predicate)
                .map(function2)
                .sorted(comparator.reversed())
                .toList();

            belowAvaragePriceList.forEach(System.out::println);
        
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
