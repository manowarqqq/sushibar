package dao;

import models.Discount;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DiscountDao {


    public Discount findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Discount.class, id);
    }

    public Discount findWithMaxId() {
        List<Discount> discounts = (List<Discount>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Discount ORDER BY id DESC ").list();
        return discounts.get(0);
    }

}
