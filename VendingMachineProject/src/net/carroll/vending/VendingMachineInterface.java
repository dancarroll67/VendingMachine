package net.carroll.vending;

import java.math.BigDecimal;
import java.util.List;

import net.carroll.vending.data.LoadedProduct;
import net.carroll.vending.state.VendingMachineStateInterface;

public interface VendingMachineInterface {

	//actions
	public void loadBankMoney(BigDecimal total);
	public void loadProducts(List<LoadedProduct> products);	
	
	public void takeMoney(BigDecimal bd);
	public int buttonPressed(int buttonID);
	public void vendProduct();
	public void giveChange();
	
	public VendingMachineStateInterface getMachineState() ;
	public void setMachineState(VendingMachineStateInterface machineState) ;
	
}
