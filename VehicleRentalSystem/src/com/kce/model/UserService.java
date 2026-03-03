package com.kce.model;

import com.kce.model.User;
import com.kce.service.AdminService;
import com.kce.service.CustomerService;
import com.kce.service.DataStore;
import com.kce.service.StaffService;

import java.util.*;

public class UserService {

    Scanner sc = new Scanner(System.in);
    int idCounter = 1;

    public void start() {

        // Default admin
        DataStore.users.add(new User(idCounter++, "Admin", "admin", "123", "admin"));

        while (true) {
            System.out.println("\n1.Register\n2.Login\n3.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: register(); break;
                case 2: login(); break;
                case 3: System.exit(0);
            }
        }
    }

    private void register() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Role (admin/staff/customer): ");
        String role = sc.nextLine();

        DataStore.users.add(new User(idCounter++, name, username, password, role));
        System.out.println("Registered Successfully!");
    }

    private void login() {

        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        for (User user : DataStore.users) {
            if (user.getUsername().equals(u) &&
                user.getPassword().equals(p)) {

                System.out.println("Login Successful!");

                switch (user.getRole()) {
                    case "admin": new AdminService().menu(); break;
                    case "staff": new StaffService().menu(); break;
                    case "customer": new CustomerService(user).menu(); break;
                }
                return;
            }
        }
        System.out.println("Invalid Login!");
    }
}