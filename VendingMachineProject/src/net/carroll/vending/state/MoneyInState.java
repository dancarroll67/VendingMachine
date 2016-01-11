package net.carroll.vending.state;

import net.carroll.vending.VendingMachineInterface;
import net.carroll.vending.data.VendingMachineActionEnum;

public class MoneyInState extends VendingMachineState implements VendingMachineStateInterface {

	@Override
	public boolean actionAllowed(VendingMachineActionEnum action) {
	
		return true;	
	}
	
	@Override
	public String toString(VendingMachineInterface context) {
		//state pattern - I can take some action on the state here (move to next state, etc..)
		return "Money In State";
	}


}
