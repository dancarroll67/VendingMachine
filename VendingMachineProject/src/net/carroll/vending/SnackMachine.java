package net.carroll.vending;

import java.math.BigDecimal;
import java.util.List;

import net.carroll.vending.data.LoadedProduct;
import net.carroll.vending.state.VendingMachineState;

public class SnackMachine extends VendingMachineBase implements VendingMachineInterface {

	
	public void loadBankMoney(BigDecimal total) {
		this.getBank().setTotalAmount(total);
	}
	public void loadProducts(List<LoadedProduct> products) {
		//set these to the vending machine
	}
	
	public void takeMoney(BigDecimal bd) {
		
	} ;
	
	public int buttonPressed() {
		return 0;  //success
	}
	
	public void vendProduct() {		
		
	};
	public void giveChange() {}
	
	
}
