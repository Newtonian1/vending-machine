package com.techelevator.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTest {

    VendingMachine vm;

    @Before
    public void createVendingMachine() {
        vm = new VendingMachine();
    }

    @Test
    public void returnChange_75c_should_return_3q() {
        //Arrange
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
        BigDecimal b = new BigDecimal("0.00");
        vm.setBalance(b);

        int[] expected = new int[]{0,0,0,0};

        //Act
        int[] result = vm.returnChange();

        //Assert
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void feedMachine_1_should_increase_balance_by_1() {
        //Arrange
        BigDecimal b = new BigDecimal("2.50");
        vm.setBalance(b);
        BigDecimal expected = new BigDecimal("3.50");

        //Act
        vm.feedMachine("1");

        //Assert
        Assert.assertEquals(expected, vm.getBalance());
    }

    @Test
    public void feedMachine_5_should_increase_balance_by_5() {
        //Arrange
        BigDecimal b = new BigDecimal("2.50");
        vm.setBalance(b);
        BigDecimal expected = new BigDecimal("7.50");

        //Act
        vm.feedMachine("5");

        //Assert
        Assert.assertEquals(expected, vm.getBalance());
    }

    @Test
    public void feedMachine_9_should_not_change_balance() {
        //Arrange
        BigDecimal b = new BigDecimal("2.50");
        vm.setBalance(b);
        BigDecimal expected = new BigDecimal("2.50");

        //Act
        vm.feedMachine("9");

        //Assert
        Assert.assertEquals(expected, vm.getBalance());
    }

}
