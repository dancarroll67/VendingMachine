package net.carroll.vending.state;

import net.carroll.vending.VendingMachineInterface;
import net.carroll.vending.data.VendingMachineActionEnum;

public class ReadyState extends VendingMachineState implements VendingMachineStateInterface {

	@Override
	public boolean actionAllowed(VendingMachineActionEnum action) {
		
		if (action== VendingMachineActionEnum.BUTTONPRESSED) {
			return false;
		}
		return true;	
	}
	@Override
	public String toString(VendingMachineInterface context) {
		return "Ready State";
	}
}
