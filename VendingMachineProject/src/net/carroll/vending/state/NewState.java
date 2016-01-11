package net.carroll.vending.state;

import net.carroll.vending.VendingMachineInterface;
import net.carroll.vending.data.VendingMachineActionEnum;

public class NewState  extends VendingMachineState implements VendingMachineStateInterface {

	@Override
	public boolean actionAllowed(VendingMachineActionEnum action) {
		
		if (action== VendingMachineActionEnum.SET_READY) {
			return true;
		}
		return false;
	
	}

	@Override
	public String toString(VendingMachineInterface context) {
		return "New State";
	}

}
