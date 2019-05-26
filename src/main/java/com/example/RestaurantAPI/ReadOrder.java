package com.example.RestaurantAPI;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadOrder {

    private Scanner scanner;

    public void openFile(){
        try{
            scanner = new Scanner(new File("orders.txt"));
            System.out.println("opened");

        }
        catch(Exception e){
            System.out.println("could not find file");
        }

    }

    public ArrayList<OrderItem> readFile(){
        ArrayList orders = new ArrayList();
        Menu menu = new Menu();
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems = menu.getMenu();
        while(scanner.hasNext()){

            ArrayList<MenuItem> foodOrder = new ArrayList<>();

            int id = Integer.parseInt(scanner.next());
            int table = Integer.parseInt(scanner.next());
            String menuItemsId = scanner.next();

            while(!menuItemsId.equals("n")){
                menuItemsId.strip();
                int itemId = Integer.parseInt(menuItemsId);
                for(MenuItem item: menuItems){
                    if(item.getId() == itemId){
                            foodOrder.add(item);
                    }
                }
                menuItemsId = scanner.next();
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setId(id);
            orderItem.setTable(table);
            orderItem.setMenuItems(foodOrder);


            orders.add(orderItem);

        }
        return orders;
    }

    public void closeFile(){
        scanner.close();
        System.out.println("closed");
    }
}