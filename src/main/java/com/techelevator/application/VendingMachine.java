package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    //Instance variables
    private BigDecimal balance = new BigDecimal("0.00");
    private Map<ItemSlot, ItemSlot> inventory = new HashMap<>();

    //Getters
    public BigDecimal getBalance() {
        return balance;
    }

    public Map<ItemSlot, ItemSlot> getInventory() {
        return inventory;
    }

    //Setters
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    //Program flow methods
    public void run() {
        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if (choice.equals("display")) {
                // display the items
            } else if (choice.equals("purchase")) {
                // make a purchase
                runPurchaseMenu();

            } else if (choice.equals("exit")) {
                // open shutDown method
                break;
            }
        }
    }

    public void runPurchaseMenu() {
        while (true) {
            UserOutput.displayPurchaseScreen();
            String purchaseChoice = UserInput.getPurchaseScreenOption();
            System.out.println(purchaseChoice);
            if (purchaseChoice.equals("feed")) {
                // open feed method
            } else if (purchaseChoice.equals("select")) {
                // open selectItemSlot method

            } else if (purchaseChoice.equals("finish")) {
                //open returnChange method
                run();
                //break;
            }
        }
    }

    //Balance management methods
    public int[] returnChange(BigDecimal b) {
        int[] coinsReturned = new int[4];
        BigDecimal dollar = new BigDecimal("1.00");
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");
        while (b.compareTo(dollar) >= 0) {
            b.subtract(dollar);
            coinsReturned[0]++;
        }
        while (b.compareTo(quarter) >= 0) {
            b.subtract(quarter);
            coinsReturned[1]++;
        }
        while (b.compareTo(dime) >= 0) {
            b.subtract(dime);
            coinsReturned[2]++;
        }
        while (b.compareTo(nickel) >= 0) {
            b.subtract(nickel);
            coinsReturned[3]++;
        }
        return coinsReturned;
    }
}
