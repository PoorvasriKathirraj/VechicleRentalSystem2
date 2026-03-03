package com.kce.model;

public class Vehicle {

    private int id;
    private String type;
    private String model;
    private double price;
    private boolean available = true;

    public Vehicle(int id, String type, String model, double price) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.price = price;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void display() {
        System.out.println(id + " | " + type + " | " + model +
                " | ₹" + price + " | " + (available ? "Available" : "Booked"));
    }
}