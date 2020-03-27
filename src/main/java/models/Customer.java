package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "first_name")
    private String firtsName;

    @Column(name = "second_name")
    private String secondName;


    @Column(name = "phone")
    private String phone;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String firtsName, String secondName, String phone) {
        this.firtsName = firtsName;
        this.secondName = secondName;
        this.phone = phone;
        orders = new ArrayList();
    }

    public void addOrder(Order order) {
        order.setCustomer(this);
        orders.add(order);
    }

    public int getId() {
        return id;
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public String getFirtsName() {
        return firtsName;
    }

    public String getSecondName() {
        return secondName;
    }


    public String getPhone() {
        return phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
