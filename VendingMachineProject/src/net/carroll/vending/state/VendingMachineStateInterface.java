package net.carroll.vending.state;

import net.carroll.vending.data.VendingMachineActionEnum;

public interface VendingMachineStateInterface {
	
	public boolean actionAllowed(VendingMachineActionEnum action);
	public String toString();

}
