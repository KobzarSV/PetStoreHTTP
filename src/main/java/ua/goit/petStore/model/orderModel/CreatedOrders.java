package ua.goit.petStore.model.orderModel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreatedOrders {

    public static LocalDateTime data = LocalDateTime.now();
    public static String timeStr = data.toString();

    public static List<Order> ordersList = new ArrayList<>();

    public static void addOrders() {
        Order order1 = new Order();
        order1.setId(1);
        order1.setPetId(1);
        order1.setQuantity(1);
        order1.setShipDate(timeStr);
        order1.setStatus(OrderStatus.PLACED);
        order1.setComplete(true);

        ordersList.add(order1);
    }
}
