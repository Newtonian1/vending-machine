package com.techelevator.application;

import com.techelevator.ui.UserInput;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private Map<String, ItemSlot> inventory = new HashMap<>();

    public Map<String, ItemSlot> getInventory() {
        return inventory;
    }

    public void setInventory() {
        String csvFileChoice = UserInput.inventoryInput();
        File file = new File(csvFileChoice);
        try {
            Scanner data = new Scanner(file);
            while (data.hasNextLine()) {
                String line = data.nextLine();
                String[] strArr = line.split(",");
                ItemSlot itemSlot = new ItemSlot(strArr[0], strArr[1], new BigDecimal(strArr[2]), strArr[3]);
                inventory.put(itemSlot.getSlot(), itemSlot);
            }
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }
    public void displayInventory(){
        for (Map.Entry<String, ItemSlot> each : inventory.entrySet()){
            System.out.println(each.getKey() + each.getValue().toString());

        }
    }
}
