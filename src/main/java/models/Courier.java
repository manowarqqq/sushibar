package models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="courier")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "first_name")
    private String firtsName;

    @Column(name = "second_name")
    private String secondName;


    @Column(name = "phone")
    private String phone;


    @Column(name = "age")
    private int age;


    @Column(name ="isAvailable")
    private boolean isAvailabe;

    @OneToMany(mappedBy = "courier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;


    public int getId() {
        return id;
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

    public int getAge() {
        return age;
    }

    public boolean isAvailabe() {
        return isAvailabe;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
