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
                UserOutput.invalidInput();
                run();
            } else if (choice.equals("display")) {
                inventory.displayInventory();
            } else if (choice.equals("purchase")) {
                runPurchaseMenu();
            } else if (choice.equals("exit")) {
                UserOutput.thankYou();
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
                UserOutput.invalidInput();
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
                UserOutput.divider();
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
        UserOutput.change(coinsReturned[0], coinsReturned[1], coinsReturned[2], coinsReturned[3]);
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
            UserOutput.itemSlotDNE();
            return "DNE";
        } else {
            BigDecimal price = slot.getPrice();
            if (slot.getQuantity() < 1) {
                UserOutput.itemOutOfStock();
                return "OUT";
            } else if (balance.compareTo(price) == -1) {
                UserOutput.insufficientFunds();
                return "NEED MONEY";
            } else {
                slot.decrementQuantity();
                UserOutput.printPurchase(slot);
                auditWriter.write("Purchased " + slot.getItemName(), balance, balance.subtract(price));
                balance = balance.subtract(price);
                UserOutput.showBalance(balance);
                return "SUCCESS";
            }
        }
    }

}

