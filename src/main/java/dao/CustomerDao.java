package dao;

import models.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CustomerDao {


    public Customer findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);
    }

    public Customer findWithMaxId() {
        List<Customer> customers = (List<Customer>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Customer ORDER BY id DESC ").list();
        return customers.get(0);
    }


    public void save(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(customer);
        tx1.commit();
        session.close();
    }

    public void update(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(customer);
        tx1.commit();
        session.close();
    }

    public void delete(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(customer);
        tx1.commit();
        session.close();
    }



    public List<Customer> findAll() {
        List<Customer> customers = (List<Customer>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM customers").list();
        return customers;
    }

}
