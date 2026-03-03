package com.kce.service;

import com.kce.model.*;
import java.util.*;
import java.time.LocalDate;

public class AdminService {

    Scanner sc = new Scanner(System.in);
    int vehicleIdCounter = 1;

    public void menu() {

        while (true) {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Update Vehicle");
            System.out.println("3. Delete Vehicle");
            System.out.println("4. View All Rentals");
            System.out.println("5. Filter Rentals by Customer");
            System.out.println("6. Filter Rentals by Date");
            System.out.println("7. Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addVehicle(); break;
                case 2: updateVehicle(); break;
                case 3: deleteVehicle(); break;
                case 4: viewAllRentals(); break;
                case 5: filterByCustomer(); break;
                case 6: filterByDate(); break;
                case 7: return;
                default: System.out.println("Invalid Choice");
            }
        }
    }

    private void addVehicle() {
        System.out.print("Vehicle Type: ");
        String type = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("Price per Day: ");
        double price = sc.nextDouble();
        sc.nextLine();

        DataStore.vehicles.add(new Vehicle(vehicleIdCounter++, type, model, price));
        System.out.println("Vehicle Added Successfully!");
    }

    private void updateVehicle() {
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Vehicle v : DataStore.vehicles) {
            if (v.getId() == id) {
                System.out.print("New Type: ");
                String type = sc.nextLine();
                System.out.println("Vehicle Updated!");
                return;
            }
        }
        System.out.println("Vehicle Not Found!");
    }

    private void deleteVehicle() {
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        DataStore.vehicles.removeIf(v -> v.getId() == id);
        System.out.println("Vehicle Deleted!");
    }

    private void viewAllRentals() {
        for (Rental r : DataStore.rentals) {
            r.display();
        }
    }

    private void filterByCustomer() {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        for (Rental r : DataStore.rentals) {
            if (r.getCustomer().equalsIgnoreCase(name)) {
                r.display();
            }
        }
    }

    private void filterByDate() {
        System.out.print("Enter Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        for (Rental r : DataStore.rentals) {
            if (r.getStart().equals(date)) {
                r.display();
            }
        }
    }
}