package com.example.RestaurantAPI;

import java.util.*;

public class Orders {

    private ArrayList<OrderItem> orders;

    public Orders() {
        this.orders = new ArrayList<>();
        orders = getData();

    }

    public List<OrderItem> getOrders() {

        return orders;
    }

    public OrderItem getOrderItem(String id){
        return getOrderItemById(id);
    }

    public OrderItem postOrderItem(String id, MenuItem item){
        Menu menu = new Menu();
        for(MenuItem mItem:menu.getMenu()){
            if(mItem.getId() == item.getId()){
                item=mItem;
            }
        }
        OrderItem order = getOrderItemById(id);
        order.getMenuItems().add(item);
        saveData();

        return order;
    }

    public OrderItem deleteOrderItem(String orderId, int itemId){
        OrderItem order = getOrderItemById(orderId);
        for(MenuItem item: order.getMenuItems()){
            if(item.getId() == itemId){
                order.getMenuItems().remove(item);
                saveData();
            }
        }
        return order;

    }

    public void postOrder (OrderItem item){
        ArrayList<MenuItem> foodOrder = new ArrayList<>();
        for(MenuItem mItem: item.getMenuItems()){
            Menu menu = new Menu();
            foodOrder.add(menu.getMenuItem(mItem.getId()));
        }
        item.setMenuItems(foodOrder);
        UUID uuid = UUID.randomUUID();
        item.setId(uuid.toString());
        orders.add(item);
        saveData();
    }


    public OrderItem deleteOrder (String id){
        OrderItem item = getOrderItemById(id);
        if(item != null){
            orders.remove(item);
            saveData();
        }
        return item;
    }

    private OrderItem getOrderItemById(String id){
        for(OrderItem item :  orders) {
            if (item.getId().equals(id))
                return item;
        }

        return null;
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
