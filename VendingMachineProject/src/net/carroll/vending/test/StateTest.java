package net.carroll.vending.test;

import net.carroll.vending.SnackMachine;
import net.carroll.vending.VendingMachineBank;
import net.carroll.vending.factory.VendingMachineFactory;
import net.carroll.vending.state.MoneyInState;
import net.carroll.vending.state.ReadyState;

public class StateTest {

	public static void main(String[] args) {
		testState();

	}
	
	public static void testState() {
		System.out.println(" StateTest testState()");
		
		//make the vending machine		
		SnackMachine sm = VendingMachineFactory.getSingleton().getSnackMachine();
		sm.setBank(new VendingMachineBank());
		sm.setVmId(100);
		
		
		//1st test, customer can't use yet as it's in new state (not ready)
		System.out.println(" the machine state: "+ sm.getMachineState().toString());
		System.out.println(" display text: "+ sm.alertText());
		
		sm.setMachineState(new ReadyState());
		System.out.println(" display text: "+ sm.alertText());
		
		sm.setMachineState(new MoneyInState());
		System.out.println(" display text: "+ sm.alertText());
		
		//System.out.println("  button pressed allowed: " +sm.getMachineState().actionAllowed(VendingMachineActionEnum.BUTTONPRESSED));
	
		
	}
}