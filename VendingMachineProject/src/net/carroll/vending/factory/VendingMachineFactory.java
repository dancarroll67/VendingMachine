package net.carroll.vending.factory;

import net.carroll.vending.DrinkMachine;
import net.carroll.vending.SnackMachine;

public class VendingMachineFactory {

	private static VendingMachineFactory singleton = null;
	
	private VendingMachineFactory() {		
	}
	
	public static VendingMachineFactory getsingleton() {
		if (singleton==null) {
			singleton = new VendingMachineFactory();
		}
			
		return singleton;
	}
	
	public SnackMachine getSnackMachine() {
		return new SnackMachine();
	}
	public DrinkMachine getDrinkMachine() {
		return new DrinkMachine();
	}

}
