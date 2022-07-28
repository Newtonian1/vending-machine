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

    @Test
    public void returnChange_2d90_should_return_2d3q1d1n() {
        //Arrange
        VendingMachine vm = new VendingMachine();
        BigDecimal b = new BigDecimal("2.90");
        vm.setBalance(b);

        int[] expected = new int[]{2,3,1,1};

        //Act
        int[] result = vm.returnChange();

        //Assert
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void returnChange_0_should_return_0() {
        //Arrange
        VendingMachine vm = new VendingMachine();
        BigDecimal b = new BigDecimal("0.00");
        vm.setBalance(b);

        int[] expected = new int[]{0,0,0,0};

        //Act
        int[] result = vm.returnChange();

        //Assert
        Assert.assertArrayEquals(expected, result);
    }
}
