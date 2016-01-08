package net.carroll.vending;

import java.math.BigDecimal;
import java.math.BigInteger;

public class VendingMachineBank {

	private BigDecimal totalAmount;
	private BigDecimal inputAmount;
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BigDecimal getInputAmount() {
		return inputAmount;
	}
	public void setInputAmount(BigDecimal inputAmount) {
		this.inputAmount = inputAmount;
	}

}
