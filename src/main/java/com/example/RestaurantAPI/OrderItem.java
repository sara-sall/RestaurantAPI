package com.example.RestaurantAPI;

import java.util.ArrayList;

public class OrderItem {
    private int id;
    private int table;
    private ArrayList<MenuItem> menuItems;
    private String other;

    public OrderItem() {
    }

    public OrderItem(int id, int table, ArrayList<MenuItem> menuItems, String other) {
        this.id = id;
        this.table = table;
        this.menuItems = menuItems;
        this.other = other;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}