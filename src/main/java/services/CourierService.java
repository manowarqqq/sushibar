package services;

import dao.CourierDao;
import models.Courier;

public class CourierService {

    private CourierDao courierDao=new CourierDao();

    public CourierService() { }

    public Courier findCourier(int id) {
        return courierDao.findById(id);
    }

    public Courier findWithMaxId() {
        return courierDao.findWithMaxId();
    }

}
