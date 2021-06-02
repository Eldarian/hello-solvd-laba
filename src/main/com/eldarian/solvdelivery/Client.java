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
        String line = scanner.nextLine();

        do {
            if(line.equals("p")) {
                operator = manager.getPhoneOperator();
            } else if (line.equals("w")) {
                operator = manager.getWebOperator();
            }
        } while (operator == null);

        System.out.println("Enter your address (Letter for street, integer for number");
        operator.handleAddress(scanner.nextLine());
        System.out.println("Choose cafe:");
        operator.handleRestaurant(scanner.nextLine());
        System.out.println("Make an order:");
        operator.handleDish(scanner.nextInt());
        System.out.println("Enter client data (phone num for phone client, login for web:");
        operator.handleClientData(scanner.nextLine());
        System.out.println("Confirm your order:");
        operator.confirmOrder(scanner.nextLine());
    }
}
