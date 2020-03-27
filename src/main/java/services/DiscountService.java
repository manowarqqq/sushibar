package services;

import dao.DiscountDao;
import models.Discount;

public class DiscountService {
    private DiscountDao discountDao = new DiscountDao();

    public DiscountService() {

    }

    public Discount findDiscount(int id) {
        return discountDao.findById(id);
    }

    public Discount findWithMaxId() {
        return discountDao.findWithMaxId();
    }
}
