package services;

import dao.PaymentTypeDao;
import models.PaymentType;

public class PaymentTypeService {

    private PaymentTypeDao paymentTypeDao=new PaymentTypeDao();

    public PaymentTypeService() {}


     public PaymentType findPaymentType(int id) {
        return  paymentTypeDao.findById(id);
     }

    public PaymentType findWithMaxId() {
        return paymentTypeDao.findWithMaxId();
    }
}
