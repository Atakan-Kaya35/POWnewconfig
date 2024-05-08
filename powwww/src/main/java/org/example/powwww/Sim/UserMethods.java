package org.example.powwww.Sim;

import org.example.powwww.entity.stationary.Patients;
import org.example.powwww.grid.City;
import org.example.powwww.grid.Order;
import org.example.powwww.grid.Stationary;
import org.example.powwww.med.Medicine;
import org.example.powwww.med.Pill;


import java.util.List;

public class UserMethods {

    public static boolean signIn(String username, String password, List<String> usernames, List<String> passwords, List<Stationary> users) {
        int index = usernames.indexOf(username);
        if (index == -1) {
            System.out.println("Username not found.");
            return false;
        }

        if (!passwords.get(index).equals(password)) {
            System.out.println("Incorrect password.");
            return false;
        }

        System.out.println("Login successful. Welcome, " + users.get(index).getName() + "!");
        return true;
    }

    public static boolean signUp(String name, int x, int y, City city, String username, String password,
                                 List<String> usernames, List<String> passwords, List<Stationary> users) {
        // Check if username is already taken
        if (usernames.contains(username)) {
            System.out.println("Username is already taken.");
            return false;
        }

        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        Stationary newUser = new Patients(name, x, y, city);

        users.add(newUser);
        usernames.add(username);
        passwords.add(password);

        System.out.println("User signed up successfully.");
        return true;
    }

    public static void addToCart(Patients patient, Medicine medicine) {
        patient.getCart().add(medicine);
        System.out.println(medicine.getName() + " added to cart.");
    }

    public static void printCart(Patients patient) {
        System.out.println("Items in cart:");
        for (Medicine medicine : patient.getCart()) {
            System.out.println(medicine.getName());
        }
    }

    // Method to place an order for the medicines in the patient's cart
    public static void makeOrder(Patients patient) {
        Order order = new Order(patient, patient.getCart());
        patient.getOrderList().add(order);
        patient.getCart().clear();
        System.out.println("Order placed successfully.");
    }

    // Uİda gösterdiğimiz arama metodu. trendyol vb. gibi harf harf yazdıkça öneri yapmasına gerek yok
    // o zor olur. ama ilacın adını tam yazıp enterlayınca sadece o ilacın simgesinin bulunduğu bir sayfa açılmalı
    public static Medicine searchForMedicine(String keyword, Patients patient) {
        String[] result = null;
        for (String[] s: Pill.getAllPills()){
            if(s.equals(keyword)){
                result = s;
            }
        }
        return new Pill(patient.getOrderList().size(), keyword);
    }

    //medicine isimleri farklı medicine objesi farklı

    // Method to print information about the patient's past 5 orders
    public static void printPast5Orders(Patients patient) {
        List<Order> pastOrders = patient.getOrderList();
        System.out.println("Past 5 orders:");
        int count = Math.min(5, pastOrders.size());
        for (int i = 0; i < count; i++) {
            Order order = pastOrders.get(i);
            System.out.println(order.toString());
        }
    }

    // Method to print information about the patient's current order
    public static void currentOrderInformation(Patients patient) {
        Order currentOrder = patient.getCurrentOrder();
        if (currentOrder != null) {
            System.out.println("Current Order ID: " + currentOrder.getOrderID());
        } else {
            System.out.println("No current order.");
        }
    }

    // Method to calculate the total cost of the medicines in the patient's cart
    public static double calculateTotalCost(Patients patient) {
        double totalCost = 0;
        for (Medicine medicine : patient.getCart()) {
            totalCost += medicine.getPrice();
        }
        return totalCost;
    }

    public static int calculateTotalProducts(Patients patient) {
        return patient.getCart().size();
    }

    // Method to calculate the estimated delivery time for the patient's order
    public static int calculateEstimatedDeliveryTime(Order order) {
        //TODO
        return 0;
    }

    // Map gösterme metodu
    public static void viewCourier(Order order) {
        //TODO
    }

    // Periodic ilaç hatırlatma metodu
    public static void showRemainders(Patients patient) {
        // TODO: Implement this method
    }
}
