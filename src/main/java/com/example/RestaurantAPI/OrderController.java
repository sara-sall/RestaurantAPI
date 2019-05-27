package com.example.RestaurantAPI;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    private Orders orders = new Orders();
    private Menu menu = new Menu();

    @GetMapping("/orders")
    public List<OrderItem> getOrders() {

        return orders.getOrders();
    }

    @PostMapping("/orders")
    public OrderItem postOrderItem(@RequestBody OrderItem item){
        orders.postOrder(item);
        return item;
    }


    @GetMapping("/orders/{id}")
    public OrderItem getOrderItem(@PathVariable String id) {

        OrderItem item = orders.getOrderItem(id);

        return item;
    }

    @DeleteMapping("/orders/{id}")
    public OrderItem deleteOrder(@PathVariable String id) {

        return orders.deleteOrder(id);
    }

    @PostMapping("/orders/{id}/item")
    public OrderItem postOrderItem(@PathVariable String id, @RequestBody MenuItem item){
        return orders.postOrderItem(id, item);
    }

    @DeleteMapping("/orders/{orderId}/item/{itemId}")
    public OrderItem deleteOrderItem(@PathVariable String orderId, @PathVariable int itemId){
        return orders.deleteOrderItem(orderId, itemId);
    }

    @GetMapping("/menu")
    public List<MenuItem> getMenu(){
        return menu.getMenu();
    }


    @GetMapping("/menu/{id}")
    public MenuItem getMenuItem(@PathVariable int id) {

        MenuItem item = menu.getMenuItem(id);

        return item;
    }





}
