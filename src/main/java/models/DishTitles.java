package models;


import javax.persistence.*;


@Entity
@Table(name = "dish_titles")
public class DishTitles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String dishName;

    @Column(name = "dish_price")
    private int dishPrice;


    public DishTitles() {

    }

    public DishTitles(String dishName, int dishPrice) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;

    }

    public int getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }


    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }
}
