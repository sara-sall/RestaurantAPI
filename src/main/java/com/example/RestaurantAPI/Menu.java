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
        for(MenuItem menu: menuItems){
            if(menu.getId() == id){
                return menu;
            }

        }
        return null;
    }

    public void addItem (MenuItem item){
        item.setId(menuItems.size());
        menuItems.add(item);
    }

    private void saveData(){
        WriteMenu writeMenu = new WriteMenu();
        writeMenu.writeMenu(menuItems);
    }

    private ArrayList<MenuItem> getData(){
/*      MenuItem pasta = new MenuItem(1, "Pasta", 80);
        MenuItem hamburger = new MenuItem(2, "Hamburgare", 50);
        MenuItem pizza = new MenuItem(3, "Pizza", 70);

        menuItems.add(0, pasta);
        menuItems.add(1, hamburger);
        menuItems.add(2, pizza);*/

        ReadMenu readMenu = new ReadMenu();

        readMenu.openFile();
        ArrayList data = readMenu.readFile();
        readMenu.closeFile();

        return data;




    }
}
