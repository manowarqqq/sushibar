package models;

import javax.persistence.*;

@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "percents")
    private int percents;




    public Discount() {
            }

    public Discount(int percents) {
    this.percents=percents;
    }

    public int getId() {
        return id;
    }

    public int getPercents() {
        return percents;
    }

    public void setPercents(int percents) {
        this.percents = percents;
    }
}
