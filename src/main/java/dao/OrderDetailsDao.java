package dao;

import models.OrderDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class OrderDetailsDao {


    public OrderDetails findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(OrderDetails.class, id);
    }


    public void save(OrderDetails orderDetails) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(orderDetails);
        tx1.commit();
        session.close();
    }



}
