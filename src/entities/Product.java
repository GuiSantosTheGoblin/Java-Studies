package entities;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public Product(){}

    public Product(String name, BigDecimal price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public String getName(){
        return this.name;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public BigDecimal totalPrice(){
        return this.price.multiply(BigDecimal.valueOf(quantity));
    }
}
