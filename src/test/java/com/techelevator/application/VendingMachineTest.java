package com.techelevator.application;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTest {

    @Test
    public void returnChange_75c_should_return_3q() {
        //Arrange
        VendingMachine vm = new VendingMachine();
        BigDecimal b = new BigDecimal("0.75");
        vm.setBalance(b);

        int[] expected = new int[]{0,3,0,0};

        //Act
        int[] result = vm.returnChange();

        //Assert
        Assert.assertArrayEquals(expected, result);
    }
}
