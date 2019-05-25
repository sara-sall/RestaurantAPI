package com.example.RestaurantAPI;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<OrderItem> orders;

    public Orders() {
        this.orders = new ArrayList<>();
        addData();
    }

    public List<OrderItem> getOrders() {

        return orders;
    }

    public OrderItem getOrderItem(int id){
        for(OrderItem item :  orders) {
            if (item.getId() == id)
                return item;
        }

        return null;
    }

    public void addOrder (OrderItem item){
        item.setId(orders.size());
        orders.add(item);
    }

    public OrderItem deleteOrder (int id){
        for(OrderItem item: orders){
            if(item.getId() == id){
                orders.remove(item);
                return item;
            }
        }
        return null;
    }

    private void addData(){
        ArrayList<MenuItem> order1 = new ArrayList<>();
        ArrayList<MenuItem> order2 = new ArrayList<>();
        ArrayList<MenuItem> order3 = new ArrayList<>();

        Menu menu = new Menu();

        order1.add(menu.getItem(1));

        order2.add(menu.getItem(2));
        order2.add(menu.getItem(3));

        order3.add(menu.getItem(3));
        order3.add(menu.getItem(1));

       // MenuItem pasta = new MenuItem("1", "Pasta", 80);
       // MenuItem hamburger = new MenuItem("2", "Hamburgare", 50);
       // MenuItem pizza = new MenuItem("3", "Pizza", 70);

       // order1.add(pasta);

       // order2.add(hamburger);
       // order2.add(pizza);

        // order3.add(pizza);
        // order3.add(pasta);

        OrderItem orderNr1 = new OrderItem(1, 1, order1, "");
        OrderItem orderNr2 = new OrderItem(2, 2, order2, "Ingen tomat på hamburgaren");
        OrderItem orderNr3 = new OrderItem(3, 3, order3, "");

        orders.add(orderNr1);
        orders.add(orderNr2);
        orders.add(orderNr3);
    }
}
