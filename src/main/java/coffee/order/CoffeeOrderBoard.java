package coffee.order;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CoffeeOrderBoard {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);
    private final List<Order> orders = new LinkedList<>();
    private int nextOrderId = 1;

    public void add(String name) {
        Order order = new Order(nextOrderId++, name);
        orders.add(order);
        logger.info("Added order: {}", order);
    }

    public void deliver() {
        if (orders.isEmpty()) {
            logger.warn("No orders to deliver.");
            return;
        }
        Order order = orders.remove(0);
        logger.info("Delivered order: {}", order);
    }

    public void deliver(int orderId) {
        Optional<Order> orderToDeliver = orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst();

        if (orderToDeliver.isEmpty()) {
            logger.warn("Order with id {} not found.", orderId);
            return;
        }

        orders.remove(orderToDeliver.get());
        logger.info("Delivered order with id {}: {}", orderId, orderToDeliver.get());
    }

    public void draw() {
        if (orders.isEmpty()) {
            logger.info("No orders in the queue.");
            return;
        }
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order);
        }
        logger.info("Current queue: \n{}", orders);
    }
}