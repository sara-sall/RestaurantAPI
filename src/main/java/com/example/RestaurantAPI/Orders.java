package com.example.RestaurantAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders {

    private ArrayList<OrderItem> orders;

    public Orders() {
        this.orders = new ArrayList<>();
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
        ArrayList<MenuItem> foodOrder = new ArrayList<>();
        for(MenuItem mItem: item.getMenuItems()){
            Menu menu = new Menu();
            foodOrder.add(menu.getMenuItem(mItem.getId()));
        }
        item.setMenuItems(foodOrder);
        item.setId(orders.size()+1);
        orders.add(item);
        saveData();
    }
    public OrderItem patchOrderItem(Map<Object, Object> map, int id){
        OrderItem item = getOrderItem(id);

        saveData();
        return item;



    }

    public OrderItem deleteOrder (int id){
        for(OrderItem item: orders){
            if(item.getId() == id){
                orders.remove(item);
                saveData();
                return item;

            }
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
