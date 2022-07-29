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

    @Override
    public String toString() {
        return
                ") Item: " + String.format("%-15s", itemName) +
                        " | Price: $" + price +
                        " | Type: " + String.format("%-6s",itemType) +
                        " | Quantity: " + quantity;
    }

    public String toStringPurchase() {
        return
                "Item vended: " + itemName +
                        " for $" + price;
    }

    public String funnyMessage() {
        if (itemType.equalsIgnoreCase("munchy")) {
            return "Munchy, munchy, so goooooooooood!";
        } else if (itemType.equalsIgnoreCase("gum")) {
            return "Chewy, chewy, lots of buuuuuuuuuubbles!";
        } else if (itemType.equalsIgnoreCase("drink")) {
            return "Drinky, drinky, slurp sluurrrrrrrrrrp!";
        } else if (itemType.equalsIgnoreCase("candy")) {
            return "Sugar, sugar, sooooooooooo sweet!";
        }
        return "";
    }
}