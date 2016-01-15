package net.carroll.vending;

import java.math.BigDecimal;
import java.math.BigInteger;

public class VendingMachineBank implements Cloneable{

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
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//BigDecimal is immutable, so basic clone() is good
	    return super.clone();
	}

}
