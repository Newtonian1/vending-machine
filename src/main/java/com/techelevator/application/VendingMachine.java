package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine {
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
}
