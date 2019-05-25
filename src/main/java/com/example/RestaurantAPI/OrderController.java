package com.example.RestaurantAPI;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class OrderController {

    private Orders orders = new Orders();

    @GetMapping("/orders")
    public List<OrderItem> getOrders() {

        return orders.getOrders();
    }

    @PostMapping("/orders")
    public OrderItem postOrderItem(@RequestBody OrderItem item){
        orders.addOrder(item);
        return item;
    }

    @GetMapping("/orders/{id}")
    public OrderItem getOrderItem(@PathVariable int id) {

        OrderItem item = orders.getOrderItem(id);

        return item;
    }

    @DeleteMapping("/orders/{id}")
    public OrderItem deleteOrder(@PathVariable int id) {

        return orders.deleteOrder(id);
    }



}
