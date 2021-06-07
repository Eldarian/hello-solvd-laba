package com.eldarian.solvdelivery;

import com.eldarian.solvdelivery.staff.Manager;
import com.eldarian.solvdelivery.staff.contact.Operator;

import java.util.Scanner;

public class Client {
    Manager manager = new Manager();
    void makeOrder() {
        //TODO make scanner more correct

        Operator operator = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to DeliereD! [p]hone or [w]eb?");
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


        System.out.println("Choose cafe, type its name or building number:");
        operator.handleRestaurant(scanner.nextLine());
        System.out.println("Choose your dish:");
        operator.handleDish(scanner.nextInt());
        System.out.println("Enter client data (phone num for phone client, login for web:");
        operator.handleClientData(scanner.nextLine());
        System.out.println("Enter your address (Building number)");
        operator.handleAddress(scanner.nextLine());
        System.out.println("Confirm your order:");
        operator.confirmOrder(scanner.nextLine());
    }
}
