package net.carroll.vending.state;

public abstract class VendingMachineState {
	
	public enum status {
		NEW,
		READY,
		MONEYIN,
		BUTTONPRESSED,
		ERROR
	}

}
