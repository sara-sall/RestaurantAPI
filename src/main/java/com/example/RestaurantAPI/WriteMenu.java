package com.example.RestaurantAPI;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteMenu {


    public void writeMenu(ArrayList<MenuItem> menu){
        String filename = "menu.txt";

        try{
            PrintWriter pw = new PrintWriter(filename);
            for(MenuItem item : menu){
                String id = String.valueOf(item.getId());
                String name = item.getName();
                String price = String.valueOf(item.getPrice());

                pw.println(id +" "+ name + " "+ price);
            }
            pw.close();


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
