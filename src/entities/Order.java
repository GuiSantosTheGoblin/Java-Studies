package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import util.OrderStatus;

public class Order {
    private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDateTime moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public Order(){}

    public void setMoment(LocalDateTime moment){
        this.moment = moment;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public LocalDateTime setMoment(){
        return this.moment;
    }

    public OrderStatus setStatus(){
        return this.status;
    }

    public Client setClient(){
        return this.client;
    }

    public List<OrderItem> setItems(){
        return this.items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        double total = 0.00;
        for(OrderItem item: items){
            total += item.subTotal();
        }

        return total;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:\n");
        sb.append("Order moment: " + moment.format(dateTimeFormat) + "\n");
        sb.append("Order status: " + this.status + "\n");
        sb.append("Client: " + this.client.getName() + " (" + this.client.getBirthDate().format(dateFormat) + ") - " + this.client.getEmail() + "\n");
        sb.append("Order items:\n");
        for(OrderItem item: this.items){
            sb.append(String.format("%s, $%.2f, Quantity: %d, Subtotal: $%.2f\n", item.getProduct().getName(), item.getProduct().getPrice(), item.getQuantity(), item.subTotal()));
        }
        sb.append(String.format("Total price: $%.2f", this.total()));

        return sb.toString();
    }    
}

/*
package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import util.OrderStatus;

public class App {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void main(String[] arg){
        Locale.setDefault(Locale.US);

        try(Scanner sc = new Scanner(System.in)){
            Client client = new Client(); 
            Order order = new Order();
            LocalDate clientBirthDate;
            int itemsQuantity;

            System.out.println("Enter client data:");
            System.out.print("Name: ");
            client.setName(sc.nextLine());
            System.out.print("Email: ");
            client.setEmail(sc.nextLine());
            System.out.print("Birth date (DD/MM/YYYY): ");
            clientBirthDate = LocalDate.parse(sc.nextLine(), dateFormat);
            client.setBirthDate(clientBirthDate);
            order.setClient(client);
            
            System.out.println("Enter order data:");
            System.out.print("Status: ");
            order.setStatus(OrderStatus.valueOf(sc.nextLine().toUpperCase()));
            System.out.print("How many items to this order? ");
            itemsQuantity = sc.nextInt();
            sc.nextLine();
            defineOrderItems(sc, itemsQuantity, order);
            order.setMoment(LocalDateTime.now());
            System.out.println();

            System.out.println(order);
        }
    }

    public static void defineOrderItems(Scanner sc, int itemsQuantity, Order order){
            for(int i = 1; i <= itemsQuantity; i++){
                Product product = new Product(); 
                OrderItem orderItem = new OrderItem();
                double productPrice;

                System.out.println("Enter #" + i + " item data:");
                System.out.print("Product name: ");
                product.setName(sc.nextLine());
                System.out.print("Product price: ");
                productPrice = sc.nextDouble();
                product.setPrice(productPrice);
                orderItem.setProduct(product);
                orderItem.setPrice(productPrice);
                System.out.print("Quantity: ");
                orderItem.setQuantity(sc.nextInt());
                sc.nextLine();

                order.addItem(orderItem);
            }
    }
}
 */
