package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    
    private Product product;


    public OrderItem(){}

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public Double getPrice(){
        return this.price;
    }

    public Product getProduct(){
        return product;
    }
    
    public Double subTotal(){
        return (double) this.quantity * this.price;
    }
}
