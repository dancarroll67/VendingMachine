package net.carroll.vending;

import java.math.BigDecimal;

import net.carroll.vending.data.VendingMachineActionEnum;
import net.carroll.vending.state.NewState;
import net.carroll.vending.state.VendingMachineState;
import net.carroll.vending.state.VendingMachineStateInterface;

public abstract class VendingMachineBase  implements VendingMachineInterface {

	private int vmId;
	private VendingMachineBank bank;
	private VendingMachineStateInterface machineState;

	public VendingMachineBase() {
		machineState = new NewState();
	}
	
	public String alertText() {
		return machineState.toString(this);
	}
	
	
	public void loadBankMoney(BigDecimal total) {
		this.getBank().setTotalAmount(total);
		//this.ma
	}	


	public int getVmId() {
		return vmId;
	}

	public void setVmId(int vmId) {
		this.vmId = vmId;
	}

	public VendingMachineBank getBank() {
		return bank;
	}

	public void setBank(VendingMachineBank bank) {
		this.bank = bank;
	}
	public VendingMachineStateInterface getMachineState() {
		return machineState;
	}
	public void setMachineState(VendingMachineStateInterface machineState) {
		this.machineState = machineState;
	}
	

}
