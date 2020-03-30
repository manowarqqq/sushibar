import com.github.javafaker.Faker;
import models.Customer;
import models.Order;
import models.OrderDetails;
import org.apache.commons.lang3.time.DateUtils;
import services.*;
import utils.RandomId;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {


    static CustomerService customerService = new CustomerService();
    static OrderService orderService = new OrderService();
    static DiscountService discountService = new DiscountService();
    static DishTitlesService dishTitlesService = new DishTitlesService();
    static OrderDetailsService orderDetailsService = new OrderDetailsService();
    static CourierService courierService = new CourierService();
    static PaymentTypeService paymentTypeService = new PaymentTypeService();
    static SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static int customerMaxId=customerService.findWithMaxId().getId();
    static int courierMaxId=courierService.findWithMaxId().getId();
    static int discountMaxId=discountService.findWithMaxId().getId();
    static int paymentTypeMaxId=paymentTypeService.findWithMaxId().getId();
    static int dishTitlesMaxId=dishTitlesService.findWithMaxId().getId();


    public static void addCustomer() {
        Faker faker = new Faker(new Locale("en_US"));
        Customer customer = new Customer(faker.name().firstName(), faker.name().lastName(), faker.phoneNumber().cellPhone().replaceAll("[ .()-]", ""));
        customerService.saveCustomer(customer);
    }

    public static void addOrder() {
        Faker faker = new Faker(new Locale("en_US"));
        Random random = new Random();
        Date dateTime = faker.date().future(180, TimeUnit.DAYS);
        Date shipping = DateUtils.addMinutes(dateTime, 25 + random.nextInt(60 - 25));
        String orderTime = sdf.format(dateTime);
        String deliveryTime = sdf.format(shipping);


        Order order = new Order(orderTime, deliveryTime);
        order.setCustomer(customerService.findCustomer(RandomId.getRandomId(customerMaxId)));
        order.setCourier(courierService.findCourier(RandomId.getRandomId(courierMaxId)));
        order.setDiscount(discountService.findDiscount(RandomId.getRandomId(discountMaxId)));
        order.setPaymentType(paymentTypeService.findPaymentType(RandomId.getRandomId(paymentTypeMaxId)));
        order.setAdress(faker.address().streetAddress());


        List<OrderDetails> orderDetails = new ArrayList();


        List<Integer> list = new ArrayList();
        int temp=dishTitlesMaxId;
        while (temp> 0) {
            list.add(temp--);
        }

        for (int i = 0; i < (1 + random.nextInt(4)); i++) {


            int current = list.get(random.nextInt(list.size()));
            OrderDetails od = new OrderDetails(dishTitlesService.findDishTitle(current), (1 + random.nextInt(2)));
            list.remove(Integer.valueOf(current));
            order.addOrderDetails(od);
        }
        orderService.saveOrder(order);


    }

    public static void main(String[] args) {
//        for (int i = 0; i < 1; i++) {
//            addCustomer();
//        }


        for (int i = 0; i < 50; i++) {
            addOrder();
        }


    }
}

