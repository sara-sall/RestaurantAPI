package com.example.RestaurantAPI;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteOrder {


    public void writeOrder(ArrayList<OrderItem> orders){
        String filename = "orders.txt";

        try{
            PrintWriter pw = new PrintWriter(filename);
            for(OrderItem item : orders){
                String id = item.getId();
                String table = String.valueOf(item.getTable());
                String foodOrder = "";
                for(MenuItem menuItem: item.getMenuItems()){
                    foodOrder += String.valueOf(menuItem.getId())+" ";
                }
                foodOrder +="n";


                pw.println(id +" "+ table + " "+ foodOrder);
                System.out.println(foodOrder);
            }
            pw.close();


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
