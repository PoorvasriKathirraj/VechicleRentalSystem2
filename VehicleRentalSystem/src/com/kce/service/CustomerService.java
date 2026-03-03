package com.kce.service;

import com.kce.model.*;
import java.util.*;

public class CustomerService {

    private User currentUser;
    Scanner sc = new Scanner(System.in);

    public CustomerService(User user) {
        this.currentUser = user;
    }

    public void menu() {

        while (true) {
            System.out.println("\n--- CUSTOMER MENU ---");
            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Browse Vehicles");
            System.out.println("4. View Rental History");
            System.out.println("5. Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: currentUser.display(); break;
                case 2: editProfile(); break;
                case 3: browseVehicles(); break;
                case 4: viewHistory(); break;
                case 5: return;
            }
        }
    }

    private void editProfile() {
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        currentUser.setName(name);
        System.out.println("Profile Updated!");
    }

    private void browseVehicles() {
        for (Vehicle v : DataStore.vehicles) {
            if (v.isAvailable()) {
                v.display();
            }
        }
    }

    private void viewHistory() {
        for (Rental r : DataStore.rentals) {
            if (r.getCustomer().equalsIgnoreCase(currentUser.getName())) {
                r.display();
            }
        }
    }
}