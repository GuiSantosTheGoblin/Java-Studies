package entities;

import java.math.BigDecimal;

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
}
