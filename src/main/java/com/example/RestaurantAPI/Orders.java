package com.example.RestaurantAPI;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private ArrayList<OrderItem> orders;

    public Orders() {
        this.orders = new ArrayList<>();
        //addData();
        //saveData();
        orders = getData();

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
        item.setId(orders.size()+1);
        orders.add(item);
        saveData();
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

        order3.add(menu.getItem(4));
        order3.add(menu.getItem(1));

       // MenuItem pasta = new MenuItem("1", "Pasta", 80);
       // MenuItem hamburger = new MenuItem("2", "Hamburgare", 50);
       // MenuItem pizza = new MenuItem("3", "Pizza", 70);

       // order1.add(pasta);

       // order2.add(hamburger);
       // order2.add(pizza);

        // order3.add(pizza);
        // order3.add(pasta);

        OrderItem orderNr1 = new OrderItem(1, 1, order1);
        OrderItem orderNr2 = new OrderItem(2, 2, order2);
        OrderItem orderNr3 = new OrderItem(3, 3, order3);

        orders.add(orderNr1);
        orders.add(orderNr2);
        orders.add(orderNr3);
    }

    private void saveData(){
        WriteOrder writeOrder = new WriteOrder();
        writeOrder.writeOrder(orders);
    }

    private ArrayList<OrderItem> getData(){

        ReadOrder readOrder = new ReadOrder();

        readOrder.openFile();
        ArrayList data = readOrder.readFile();
        readOrder.closeFile();

        return data;




    }
}
