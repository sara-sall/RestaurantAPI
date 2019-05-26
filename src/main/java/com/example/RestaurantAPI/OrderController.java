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

    //TODO Better ID add
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

    //TODO patch
    @PatchMapping("/orders({id}")
    public OrderItem patchOrderItem(@PathVariable int id, @RequestBody Map<Object, Object> map){


        return orders.patchOrderItem(map, id);
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
