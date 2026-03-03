package com.kce.model;

import java.time.LocalDate;

public class Rental {

    private int id;
    private String customer;
    private int vehicleId;
    private LocalDate start;
    private LocalDate end;
    private boolean active = true;

    public Rental(int id, String customer, int vehicleId,
                  LocalDate start, LocalDate end) {
        this.id = id;
        this.customer = customer;
        this.vehicleId = vehicleId;
        this.start = start;
        this.end = end;
    }

    public String getCustomer() { return customer; }
    public String getVehicleType() { return ""; }
    public LocalDate getStart() { return start; }

    public void close() { active = false; }

    public void display() {
        System.out.println(id + " | " + customer +
                " | Vehicle: " + vehicleId +
                " | " + start + " to " + end +
                " | " + (active ? "Active" : "Closed"));
    }
}