package services;

import dao.CustomerDao;
import models.Customer;

import java.util.List;

public class CustomerService {

    private CustomerDao customerDao = new CustomerDao();
//    private static int  customerMaxId;

    public CustomerService() {
    }

    public Customer findCustomer(int id) {
        return customerDao.findById(id);
    }

    public Customer findWithMaxId() {
        return customerDao.findWithMaxId();
    }

//    public static int getCustomerMaxId() {
//        return new CustomerService().findWithMaxId().getId();
//    }

    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }


    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }



}
