package com.eldarian.solvdelivery;

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

    void sendOrder() {
        Operator operator = contactOperator();
        Order order = generateOrder(operator);
        confirmOrder(operator, order);
    }

    private Operator contactOperator() {
        System.out.println("Welcome to DelivereD! [p]hone or [w]eb?");
        Scanner scanner = new Scanner(System.in);
        Operator operator = null;

        do {
            String line = scanner.nextLine();
            switch (line) {
                case "phone":
                case "p":
                    operator = manager.getPhoneOperator();
                    System.out.println("Called Phone Operator");
                    break;
                case "web":
                case "w":
                    operator = manager.getWebOperator();
                    System.out.println("Called Web Operator");
                    break;
                default:
                    System.out.println("Incorrect type, try again. [p]hone or [w]eb?");
                    break;
            }
        } while (operator == null);
        return operator;
    }

    private Order generateOrder(Operator operator) { //QUESTION transfer to operator class?
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose cafe, type its name:");
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
