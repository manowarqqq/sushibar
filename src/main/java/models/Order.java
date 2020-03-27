package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order_time")
    private String orderTime;

    @Column(name = "delivery_time")
    private String deliveryTime;

    @Column(name="adress")
    private String adress;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private Courier courier;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="payment_type_id")
    private PaymentType paymentType;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetails;

    public Order() {
    }

    public Order(String orderTime, String deliveryTime) {
        this.orderTime = orderTime;
        this.deliveryTime=deliveryTime;
        this.orderDetails = new ArrayList();

    }

    public int getId() {
        return id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public Discount getDiscount() {
        return discount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public void addOrderDetails(OrderDetails orderDetail) {
        orderDetail.setOrder(this);
        orderDetails.add(orderDetail);
    }


}
