package com.techelevator.ui;

import com.techelevator.application.ItemSlot;

import java.math.BigDecimal;

public class UserOutput {
    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }
    public static void displayPurchaseScreen(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                 Purchase Menu");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void invalidInput() {
        System.out.println("Please enter a valid input");
    }

    public static void thankYou() {
        System.out.println("Thank you for shopping!");
    }

    public static void divider() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void change(int dollars, int quarters, int dimes, int nickels) {
        if (dollars == 0 && quarters == 0 && dimes == 0 && nickels == 0) {
            return;
        }
        System.out.println("Clink!");
        System.out.println("Change dispensed: " + dollars + " dollar(s), " + quarters + " quarter(s), " + dimes + " dime(s), and " + nickels + " nickel(s)");
    }

    public static void itemSlotDNE() {
        System.out.println();
        System.out.println("Item slot does not exist");
        System.out.println();
    }

    public static void itemOutOfStock() {
        System.out.println();
        System.out.println("Item is out of stock");
        System.out.println();
    }

    public static void insufficientFunds() {
        System.out.println();
        System.out.println("Insufficient funds");
        System.out.println();
    }

    public static void printPurchase(ItemSlot slot) {
        System.out.println(slot.toStringPurchase());
        System.out.println(slot.funnyMessage());
    }

    public static void showBalance(BigDecimal balance) {
        System.out.println("Balance: $" + balance);
    }

    public static void fileNotFound() {
        System.err.println("File not found");
    }

    public static void printItem(String item) {
        System.out.println(item);
    }

    public static void salesReport() {
        System.out.println("Sales report generated");
    }
}
