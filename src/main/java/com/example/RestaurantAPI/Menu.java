package com.example.RestaurantAPI;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private ArrayList<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
        menuItems=getData();
    }

    public ArrayList<MenuItem> getMenu() {

        return menuItems;
    }

    public MenuItem getItem(int id){
        for(MenuItem item: menuItems){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
    public MenuItem getMenuItem(int id){
        for(MenuItem item :  menuItems) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }

    private void saveData(){
        WriteMenu writeMenu = new WriteMenu();
        writeMenu.writeMenu(menuItems);
    }

    private ArrayList<MenuItem> getData(){
        ReadMenu readMenu = new ReadMenu();

        readMenu.openFile();
        ArrayList data = readMenu.readFile();
        readMenu.closeFile();

        return data;




    }
}
