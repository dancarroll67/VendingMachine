package net.carroll.vending;

import java.math.BigInteger;

public abstract class VendingMachineBase {

	private int vmId;
	private VendingMachineBank bank;

		
	public VendingMachineBase() {
		
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
	
	
	

}
