package models;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name="quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_titles_id")
    private DishTitles dishTitles;

    public OrderDetails(DishTitles dishTitles, int quantity ) {
        this.quantity = quantity;
        this.dishTitles = dishTitles;
    }

    public void setOrder(Order order) {
        this.order=order;
    }
}

