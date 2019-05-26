package com.example.RestaurantAPI;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadMenu {

    private Scanner scanner;

    public void openFile(){
        try{
            scanner = new Scanner(new File("menu.txt"));
            System.out.println("opened");

        }
        catch(Exception e){
            System.out.println("could not find file");
        }

    }

    public ArrayList<MenuItem> readFile(){
        ArrayList menu = new ArrayList();
        while(scanner.hasNext()){
            int id = Integer.parseInt(scanner.next());
            String name = scanner.next();
            double price = Double.parseDouble(scanner.next());

            MenuItem menuItem = new MenuItem();
            menuItem.setId(id);
            menuItem.setName(name);
            menuItem.setPrice(price);

            menu.add(menuItem);

        }
        return menu;
    }

    public void closeFile(){
        scanner.close();
        System.out.println("closed");
    }
}
