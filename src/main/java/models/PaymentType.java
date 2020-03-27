package models;


import javax.persistence.*;

@Entity
@Table(name="payment_types")
public class PaymentType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "type")
    private String type;


    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
