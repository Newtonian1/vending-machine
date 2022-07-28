package com.techelevator.ui;

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
        System.out.println("Select a .csv file to load");
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


}

