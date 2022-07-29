package com.techelevator.application;

import com.techelevator.ui.UserInput;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryTest{
    Inventory testInventory = new Inventory();

    @Test
    public void test_set_inventory(){
        testInventory.setInventory();

        Map<String, ItemSlot> result = new HashMap<>();
        ItemSlot testItem1 = new ItemSlot("A1", "U-Chews", new BigDecimal("1.65"), "Gum");
        result.put(testItem1.getSlot(), testItem1);
        ItemSlot testItem2 = new ItemSlot("A2", "Ginger Ayle", new BigDecimal("1.85"), "Drink");
        result.put(testItem2.getSlot(), testItem2);
        ItemSlot testItem3 = new ItemSlot("A3", "Snykkers", new BigDecimal("4.25"), "Candy");
        result.put(testItem3.getSlot(), testItem3);
        ItemSlot testItem4 = new ItemSlot("A4", "Chippos", new BigDecimal("3.85"), "Munchy");
        result.put(testItem4.getSlot(), testItem4);
        ItemSlot testItem5 = new ItemSlot("B1", "Stackers", new BigDecimal("2.65"), "Munchy");
        result.put(testItem5.getSlot(), testItem5);
        ItemSlot testItem6 = new ItemSlot("B2", "Papsi", new BigDecimal("3.45"), "Drink");
        result.put(testItem6.getSlot(), testItem6);
        ItemSlot testItem7 = new ItemSlot("B3", "Mountain Melter", new BigDecimal("3.55"), "Drink");
        result.put(testItem7.getSlot(), testItem7);
        ItemSlot testItem8 = new ItemSlot("B4", "Wonka Bar", new BigDecimal("2.35"), "Candy");
        result.put(testItem8.getSlot(), testItem8);
        ItemSlot testItem9 = new ItemSlot("C1", "Caramel Bar", new BigDecimal("2.25"), "Candy");
        result.put(testItem9.getSlot(), testItem9);
        ItemSlot testItem10 = new ItemSlot("C2", "7Down", new BigDecimal("3.25"), "Drink");
        result.put(testItem10.getSlot(), testItem10);
        ItemSlot testItem11 = new ItemSlot("C3", "Moonpie", new BigDecimal("2.95"), "Candy");
        result.put(testItem11.getSlot(), testItem11);
        ItemSlot testItem12 = new ItemSlot("C4", "Popcorn", new BigDecimal("1.75"), "Munchy");
        result.put(testItem12.getSlot(), testItem12);
        ItemSlot testItem13 = new ItemSlot("D1", "Teaberry", new BigDecimal("1.65"), "Gum");
        result.put(testItem13.getSlot(), testItem13);
        ItemSlot testItem14 = new ItemSlot("D2", "Preengles", new BigDecimal("2.35"), "Munchy");
        result.put(testItem14.getSlot(), testItem14);
        ItemSlot testItem15 = new ItemSlot("D3", "Singlemint Gum", new BigDecimal("2.35"), "Gum");
        result.put(testItem15.getSlot(), testItem15);
        ItemSlot testItem16 = new ItemSlot("D4", "Chiclets", new BigDecimal("1.35"), "Gum");
        result.put(testItem16.getSlot(), testItem16);

        String actual = testInventory.getInventory().toString();
        String strResult = result.toString();

        Assert.assertEquals(actual, strResult);
        }

    }

