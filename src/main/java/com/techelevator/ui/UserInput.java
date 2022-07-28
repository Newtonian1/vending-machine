package com.techelevator.ui;

import com.techelevator.application.VendingMachine;

import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("option = " + option);
        if (option.equals("d")) {
            return "display";
        }
        else if (option.equals("p")) {
            return "purchase";
        }
        else if (option.equals("e")) {
            return "exit";
        }
        else {
            return "";
        }

    }
    public static String getPurchaseScreenOption(){
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedPurchaseOption = scanner.nextLine();
        String purchaseOption = selectedPurchaseOption.trim().toLowerCase();
        if (purchaseOption.equals("m")) {
            return "feed";
        }
        else if (purchaseOption.equals("s")) {
            return "select";
        }
        else if (purchaseOption.equals("f")) {
            return "finish";
        }
        else {
            return "";
        }

    }
    public static String inventoryInput(){
        //temp
        //for testing/assignment purposes
        //ideally, inventory source would be read form the same file everytime
        //but for the sake of the exercise, the user is prompted to pick which file is loaded
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a .csv file to load: ");
        String csvInput = scanner.nextLine();
        String csvOutput = "";
        if (csvInput.substring(csvInput.length() - 4, csvInput.length()). equals(".csv")){
            csvOutput = csvInput;
            //return csvOutput;
        }else{
            System.out.println("Please enter a valid .csv file");
            inventoryInput();
        }
        return csvOutput;

    }

    public static String promptFeedMachine() {
        Scanner userInput = new Scanner(System.in);
        int counter = 0;
        while (true) {
            System.out.println("Please enter a dollar amount (1, 5, 10, or 20) to feed the machine:");
            String input = userInput.nextLine();
            if (input.equals("1") || input.equals("5") || input.equals("10") || input.equals("20")) {
                return input;
            }
            System.err.println("Please enter a valid input");
            counter++;
            if (counter > 5) {
                System.err.println("ARE YOU ILLITERATE?");
            }
        }
    }
    public static String selectItemSlot(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the item slot code of the item you want (i.e. A1): ");
        String requestedItemSlot = scanner.nextLine();
        return requestedItemSlot;
    }
}

