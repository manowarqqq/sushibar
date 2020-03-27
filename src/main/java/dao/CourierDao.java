package dao;

import models.Courier;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CourierDao {
    public Courier findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Courier.class, id);
    }

    public Courier findWithMaxId() {
        List<Courier> couriers = (List<Courier>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Courier ORDER BY id DESC ").list();
        return couriers.get(0);
    }

}
