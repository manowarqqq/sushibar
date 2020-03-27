package dao;

import models.DishTitles;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DishTitlesDao {

    public DishTitles findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(DishTitles.class, id);
    }

    public DishTitles findWithMaxId() {
        List<DishTitles> dishTitles = (List<DishTitles>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM DishTitles ORDER BY id DESC ").list();
        return dishTitles.get(0);
    }

//    public void save(DishTitles dishTitle) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.save(dishTitle);
//        tx1.commit();
//        session.close();
//    }




}
