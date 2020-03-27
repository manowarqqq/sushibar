package services;

import dao.OrderDetailsDao;
import models.OrderDetails;

public class OrderDetailsService {


    private OrderDetailsDao orderDetailsDao = new OrderDetailsDao();

    public OrderDetailsService() {
    }
    public OrderDetails findOrder(int id) {
        return orderDetailsDao.findById(id);
    }

    public void saveOrderDetails(OrderDetails orderDetails) {
        orderDetailsDao.save(orderDetails);
    }


}
