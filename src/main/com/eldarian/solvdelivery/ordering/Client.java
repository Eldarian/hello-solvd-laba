package com.eldarian.solvdelivery.ordering;

import com.eldarian.solvdelivery.city.Building;
import com.eldarian.solvdelivery.city.Restaurant;
import com.eldarian.solvdelivery.city.Street;
import com.eldarian.solvdelivery.staff.Manager;
import com.eldarian.solvdelivery.staff.contact.Operator;

import java.util.Scanner;

public class Client {
    Manager manager;

    public Client(Manager manager) {
        this.manager = manager;
    }

    public Client() {
        this.manager = new Manager();
    }

    public void sendOrder() {
        Operator operator = contactOperator();
        if(operator == null) {
            System.out.println("No operator available. Please try again later");
        }
        Order order = generateOrder(operator);
        confirmOrder(operator, order);
    }

    private Operator contactOperator() {
        System.out.println("Welcome to DelivereD! [p]hone or [w]eb?");
        Scanner scanner = new Scanner(System.in);
        Operator operator = null;
        int attempt = 0;

        do {
            String line = scanner.nextLine();
            switch (line) {
                case "phone":
                case "p":
                    operator = manager.getPhoneOperator();
                    if(operator == null) {
                        System.out.println("There is no available phone operator or there is error");
                        break;
                    }
                    System.out.println("Called Phone Operator " + operator.getName());
                    break;
                case "web":
                case "w":
                    operator = manager.getWebOperator();
                    if(operator == null) {
                        System.out.println("There is no available phone operator or there is error");
                        break;
                    }
                    System.out.println("Called Web Operator " + operator.getName());
                    break;
                default:
                    System.out.println("Incorrect type, try again. [p]hone or [w]eb?");
                    break;
            }
            attempt++;
        } while (operator == null && attempt < 10);
        return operator;
    }

    private Order generateOrder(Operator operator) { //PENDING transfer to operator class?
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose cafe, type its name or id:");
        operator.printRestaurants();
        Restaurant restaurant = operator.findRestaurant(scanner.nextLine()); //TODO NULL-check
        order.setRestaurant(restaurant);

        System.out.println("Choose your dish:");
        restaurant.printMenu();
        Dish dish = restaurant.findDish(scanner.nextLine());
        order.setDish(dish);

        System.out.println("Enter your address (Street name):");
        operator.printStreetNames();
        Street street = operator.findStreet(scanner.nextLine());

        System.out.println("Enter your address (Building number):");
        Building destination = operator.findBuilding(street, scanner.nextInt());
        order.setDestination(destination);

        return order;
    }

    private void confirmOrder(Operator operator, Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Confirm your order, [y]es or [n]o: " + order);
        boolean isCorrect = false;
        do {
            String line = scanner.nextLine();
            switch (line) {
                case "yes":
                case "y":
                    if(operator.handleOrder(order)) {
                        System.out.println("Thanks for ordering!");
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
