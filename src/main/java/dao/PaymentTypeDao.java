package dao;


import models.PaymentType;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PaymentTypeDao {

    public PaymentType findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PaymentType.class, id);
    }

    public PaymentType findWithMaxId() {
        List<PaymentType> types = (List<PaymentType>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM PaymentType ORDER BY id DESC ").list();
        return types.get(0);
    }
}
