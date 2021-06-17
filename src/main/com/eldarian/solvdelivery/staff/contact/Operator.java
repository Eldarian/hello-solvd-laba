package com.eldarian.solvdelivery.staff.contact;

import com.eldarian.solvdelivery.ordering.Dish;
import com.eldarian.solvdelivery.ordering.Order;
import com.eldarian.solvdelivery.city.Building;
import com.eldarian.solvdelivery.city.Restaurant;
import com.eldarian.solvdelivery.city.Street;
import com.eldarian.solvdelivery.services.CityService;
import com.eldarian.solvdelivery.staff.Employee;
import com.eldarian.solvdelivery.staff.Manager;

import java.util.Scanner;

public abstract class Operator extends Employee {
    private Manager manager;
    private CityService cityService;

    public Operator(Manager manager) {
        super();
        this.manager = manager;
        manager.addOperator(this);
        cityService = manager.getCityService();
    }

    public abstract void handleClientData(String data);

    @Override
    public void handleOrder(Order order) {
        manager.handleOrder(order);
    }

    @Override
    public boolean canHandleOrder(Order order) {
        if(order.isValid()) {
            return manager.canHandleOrder(order);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Operator{" + "id=" + getId() +
                ", name='" + getName() +
                "manager=" + manager +
                '}';
    }

    private Restaurant findRestaurant(String string) {
        if(string.matches("\\d+")) {
            return cityService.findRestaurant(Integer.parseInt(string));
        }
        return cityService.findRestaurant(string);
    }

    private Building findBuilding(Street street, int number) {
        return cityService.findBuilding(street, number);
    }

    private Street findStreet(String name) {
        return cityService.findStreet(name);
    }

    public Manager getManager() {
        return manager;
    }

    private void printRestaurants() {
        for (String restaurantName : cityService.getRestaurantNames()) {
            System.out.println(restaurantName);
        }
    }

    private void printStreetNames() {
        for (String streetName : cityService.getStreetNames()) {
            System.out.println(streetName);
        }
    }

    public Order generateOrder() {
        Order order = new Order();
        Restaurant restaurant;
        int attempt = 0;
        do {
            restaurant = chooseRestaurant(order);
            attempt++;
        } while (restaurant == null && attempt < 10);
        chooseDish(order, restaurant, 0);
        chooseDestination(order);
        return order;
    }

    private void chooseDish(Order order, Restaurant restaurant, int attempt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your dish:");
        restaurant.printMenu();
        Dish dish = restaurant.findDish(scanner.nextLine());
        if(dish == null && attempt < 3) {
            System.out.println("Wrong input, try again");
            chooseDish(order, restaurant, ++attempt);
        }
        order.setDish(dish);
    }

    private Restaurant chooseRestaurant(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose cafe, type its name or id:");
        printRestaurants();
        Restaurant restaurant = findRestaurant(scanner.nextLine()); //TODO NULL-check
        order.setRestaurant(restaurant);
        return restaurant;
    }

    private void chooseDestination(Order order) {
        Street street = chooseStreet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your address (Building number):");
        Building destination = findBuilding(street, scanner.nextInt());
        order.setDestination(destination);
    }

    private Street chooseStreet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your address (Street name):");
        printStreetNames();
        Street street = findStreet(scanner.nextLine());
        return street;
    }

    public void confirmOrder(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Confirm your order, [y]es or [n]o: " + order);
        boolean isCorrect = false;
        do {
            String line = scanner.nextLine();
            switch (line) {
                case "yes":
                case "y":
                    if(canHandleOrder(order)) {
                        System.out.println("Your order has been sent to delivery service");
                        handleOrder(order);
                    } else {
                        System.out.println("Your order is incorrect.");
                    }
                    isCorrect = true;
                    break;
                case "no":
                case "n":
                    System.out.println("Try again!");
                    isCorrect = true;
                    break;
                default:
                    System.out.println("Incorrect type, try again.");
                    break;
            }

        } while (!isCorrect);
    }
}

