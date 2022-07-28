package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import com.techelevator.application.Inventory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    //Instance variables
    private BigDecimal balance = new BigDecimal("0.00");
    //private Map<String, ItemSlot> inventory = new HashMap<>();

    //Getters
    public BigDecimal getBalance() {
        return balance;
    }
    Inventory inventory = new Inventory();


    /*public Map<String, ItemSlot> getInventory() {
        return inventory;
    }*/

    //Setters
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    //Program flow methods

    public void startUp(){
        inventory.setInventory();
        run();
    }
    public void run() {
        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if (choice.equals("")){
                UserOutput.displayMessage("Please enter a valid input");
                run();
            }else if (choice.equals("display")) {
                inventory.displayInventory();
            } else if (choice.equals("purchase")) {
                // make a purchase
                runPurchaseMenu();

            } else if (choice.equals("exit")) {
                // open shutDown method
                System.out.println("Thank you for shopping!");
                System.exit(0);
            }
        }
    }

    public void runPurchaseMenu() {
        while (true) {
            UserOutput.displayPurchaseScreen();
            String purchaseChoice = UserInput.getPurchaseScreenOption();
            System.out.println(purchaseChoice);
            if (purchaseChoice.equals("")) {
                UserOutput.displayMessage("Please enter a valid input");
                runPurchaseMenu();
            }else if (purchaseChoice.equals("feed")) {
                String feed = UserInput.promptFeedMachine();
                feedMachine(feed);
                UserOutput.displayMessage("Current balance: $" + balance);
            } else if (purchaseChoice.equals("select")) {
                // open selectItemSlot method
                String itemSlot = UserInput.selectItemSlot();
                dispenseItem(itemSlot);

            } else if (purchaseChoice.equals("finish")) {
                returnChange();
                run();
                //break;
            }
        }
    }

    //Balance management methods
    public int[] returnChange() {
        int[] coinsReturned = new int[4];
        BigDecimal dollar = new BigDecimal("1.00");
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");
        while (balance.compareTo(dollar) >= 0) {
            balance = balance.subtract(dollar);
            coinsReturned[0]++;
        }
        while (balance.compareTo(quarter) >= 0) {
            balance = balance.subtract(quarter);
            coinsReturned[1]++;
        }
        while (balance.compareTo(dime) >= 0) {
            balance = balance.subtract(dime);
            coinsReturned[2]++;
        }
        while (balance.compareTo(nickel) >= 0) {
            balance = balance.subtract(nickel);
            coinsReturned[3]++;
        }
        System.out.println("Clink!");
        System.out.println("Change dispensed: " + coinsReturned[0] + " dollar(s), " + coinsReturned[1] + " quarter(s), " + coinsReturned[2] + " dime(s), and " + coinsReturned[3] + " nickel(s)");
        return coinsReturned;
    }

    public void feedMachine(String userInput) {
        switch(userInput) {
            case "1":
                balance = balance.add(new BigDecimal("1.00"));
                break;
            case "5":
                balance = balance.add(new BigDecimal("5.00"));
                break;
            case "10":
                balance = balance.add(new BigDecimal("10.00"));
                break;
            case "20":
                balance = balance.add(new BigDecimal("20.00"));
                break;
        }
    }
    /*public void setInventory(){
        String csvFileChoice = UserInput.inventoryInput();
        File file = new File(csvFileChoice);
        try{
            Scanner data = new Scanner(file);
            while (data.hasNextLine()){
                String line = data.nextLine();
                String[] strArr = line.split(",");
                ItemSlot itemSlot = new ItemSlot(strArr[0], strArr[1], new BigDecimal(strArr[2]), strArr[3]);
                inventory.put(itemSlot.getSlot(), itemSlot);
            }
        }catch (IOException e){
            System.out.println("file not found");
        }*/

    public void dispenseItem(String itemSlot){
        if (!inventory.getInventory().containsKey(itemSlot)){
            UserOutput.displayMessage("Item slot does not exist");
            runPurchaseMenu();
        }else if (inventory.getInventory().containsKey(itemSlot)){
            if (inventory.getInventory().get(itemSlot).getQuantity() < 1){
                UserOutput.displayMessage("Item is out of stock");
                runPurchaseMenu();
            }else if (balance.compareTo(inventory.getInventory().get(itemSlot).getPrice()) == -1){
                UserOutput.displayMessage("Insufficient funds");
                runPurchaseMenu();
            }
            else{
                System.out.println(inventory.getInventory().get(itemSlot).toString());
                System.out.println(inventory.getInventory().get(itemSlot).funnyMessage());
                balance = balance.subtract(inventory.getInventory().get(itemSlot).getPrice());
                System.out.println("balance: $" + balance);
                inventory.getInventory().get(itemSlot).decrementQuantity();
                runPurchaseMenu();
            }
        }
    }

    }

