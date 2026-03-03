package com.kce.service;

import com.kce.model.*;
import java.util.*;
import java.time.LocalDate;

public class StaffService {

    Scanner sc = new Scanner(System.in);
    int rentalIdCounter = 1;

    public void menu() {

        while (true) {
            System.out.println("\n--- STAFF MENU ---");
            System.out.println("1. Register Rental");
            System.out.println("2. Close Rental");
            System.out.println("3. Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: registerRental(); break;
                case 2: closeRental(); break;
                case 3: return;
            }
        }
    }

    private void registerRental() {

        System.out.print("Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Vehicle ID: ");
        int vehicleId = sc.nextInt();
        sc.nextLine();

        System.out.print("Start Date (YYYY-MM-DD): ");
        LocalDate start = LocalDate.parse(sc.nextLine());

        System.out.print("End Date (YYYY-MM-DD): ");
        LocalDate end = LocalDate.parse(sc.nextLine());

        DataStore.rentals.add(new Rental(rentalIdCounter++, name, vehicleId, start, end));

        System.out.println("Rental Registered Successfully!");
    }

    private void closeRental() {

        System.out.print("Enter Rental ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Rental r : DataStore.rentals) {
            r.close();
            System.out.println("Rental Closed!");
            return;
        }
        System.out.println("Rental Not Found!");
    }
}