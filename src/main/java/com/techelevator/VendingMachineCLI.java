package com.techelevator;


import com.techelevator.application.Inventory;
import com.techelevator.application.VendingMachine;

public class VendingMachineCLI {

	public static void main(String[] args) {

		VendingMachine vendingMachine = new VendingMachine();
		/*Inventory inventory = new Inventory();
		inventory.setInventory();*/
		vendingMachine.startUp();
	}
}
