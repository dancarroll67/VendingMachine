package net.carroll.vending.state;

import net.carroll.vending.data.VendingMachineActionEnum;

public class MoneyInState extends VendingMachineState implements VendingMachineStateInterface {

	@Override
	public boolean actionAllowed(VendingMachineActionEnum action) {
	
		return true;
	
	}

}
