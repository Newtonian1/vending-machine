package com.techelevator.application;

import java.math.BigDecimal;

public class ItemSlot {
    //Instance Variables
    private String slot;
    private String itemName;
    private BigDecimal price;
    private String itemType;
    private int quantity = 6;

    //Constructor
    public ItemSlot(String slot, String itemName, BigDecimal price, String itemType) {
        this.slot = slot;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
    }

    //Getters
    public String getSlot() {
        return slot;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    //Other methods
    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
}