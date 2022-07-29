package com.techelevator.application;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ItemSlotTest {
    ItemSlot itemSlot = new ItemSlot("Z9", "Joe's Toenails", new BigDecimal("2.50"), "munchy");

    @Test
    public void print_funny_message_for_toenails(){
        //Arrange
        String result = "Munchy, munchy, so good";

        //Act
        String expected = itemSlot.funnyMessage();

        //Assert
        Assert.assertEquals(expected, result);
    }
    @Test
    public void test_standard_decrement_quantity(){
        //Arrange
        int result = 5;

        //Act
        itemSlot.decrementQuantity();
        int expected =

                //Assert
        Assert.assertEquals(expected, result);

}
