package services;

import dao.OrderDao;
import models.Order;

import java.util.List;

public class OrderService {
    private OrderDao orderDao = new OrderDao();

    public OrderService() {
    }
    public Order findOrder(int id) {
        return orderDao.findById(id);
    }

    public List<Order> findAllOrders() {
        return orderDao.findAll();
    }

    public void saveOrder(Order order) {
        orderDao.save(order);
    }

    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }

    public void updateOrder(Order order) {
        orderDao.update(order);
    }



    public Order findOrderById(int id) {
        return orderDao.findOrderById(id);
    }

}
