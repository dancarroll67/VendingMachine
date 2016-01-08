package net.carroll.vending;

import java.math.BigDecimal;
import java.util.List;

import net.carroll.vending.data.LoadedProduct;

public interface VendingMachineInterface {

	public void loadBankMoney(BigDecimal total);
	public void loadProducts(List<LoadedProduct> products);
	
	
	public void takeMoney(BigDecimal bd);
	public int buttonPressed();
	public void vendProduct();
	public void giveChange();
}
