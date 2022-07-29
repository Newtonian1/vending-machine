package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;

public class VendingMachine {
    //Instance variables
    private BigDecimal balance = new BigDecimal("0.00");
    //private Map<String, ItemSlot> inventory = new HashMap<>();

    //Getters
    public BigDecimal getBalance() {
        return balance;
    }

    Inventory inventory = new Inventory();
    AuditWriter auditWriter = new AuditWriter();


    /*public Map<String, ItemSlot> getInventory() {
        return inventory;
    }*/

    //Setters
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    //Program flow methods

    public void startUp() {
        inventory.setInventory();
        run();
    }

    public void run() {
        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if (choice.equals("")) {
                UserOutput.displayMessage("Please enter a valid input");
                run();
            } else if (choice.equals("display")) {
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
            String purchaseChoice = UserInput.getPurchaseScreenOption(balance);
            System.out.println(purchaseChoice);
            if (purchaseChoice.equals("")) {
                UserOutput.displayMessage("Please enter a valid input");
                runPurchaseMenu();
            } else if (purchaseChoice.equals("feed")) {
                String feed = UserInput.promptFeedMachine();
                if (feed.equals("0")) {
                    continue;
                }
                feedMachine(feed);
            } else if (purchaseChoice.equals("select")) {
                // open selectItemSlot method
                inventory.displayInventory();
                System.out.println();
                System.out.println("***************************************************");
                System.out.println();
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
        auditWriter.write("CHANGE GIVEN", balance, new BigDecimal("0.00"));
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
        switch (userInput) {
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
            default:
                break;
        }
        auditWriter.write("MONEY FED", balance.subtract(new BigDecimal(userInput)), balance);
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

    public String dispenseItem(String itemSlot) {
        ItemSlot slot = inventory.getInventory().get(itemSlot);
        if (!inventory.getInventory().containsKey(itemSlot)) {
            UserOutput.displayMessage("Item slot does not exist");
            return "DNE";
        } else {
            BigDecimal price = slot.getPrice();
            if (slot.getQuantity() < 1) {
                UserOutput.displayMessage("Item is out of stock");
                return "OUT";
            } else if (balance.compareTo(price) == -1) {
                UserOutput.displayMessage("Insufficient funds");
                return "NEED MONEY";
            } else {
                slot.decrementQuantity();
                System.out.println(slot.toStringPurchase());
                System.out.println(slot.funnyMessage());
                auditWriter.write("Purchased " + slot.getItemName(), balance, balance.subtract(price));
                balance = balance.subtract(price);
                System.out.println("balance: $" + balance);
                return "SUCCESS";
            }
        }
    }

}

