package com.techelevator.application;

import com.techelevator.ui.UserInput;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class InventoryTest extends Inventory{
    Inventory testInventory = new Inventory();

    @Override
    public void setInventory() {
        String csvFileChoice = "toenails.csv";
        File file = new File(csvFileChoice);
        try {
            Scanner data = new Scanner(file);
            while (data.hasNextLine()) {
                String line = data.nextLine();
                String[] strArr = line.split(",");
                ItemSlot itemSlot = new ItemSlot(strArr[0], strArr[1], new BigDecimal(strArr[2]), strArr[3]);
                testInventory.getInventory().put(itemSlot.getSlot(), itemSlot);
            }
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }

    @Test
    public void test_set_inventory(){
        Inventory testInventory = new Inventory();


        }

    }

