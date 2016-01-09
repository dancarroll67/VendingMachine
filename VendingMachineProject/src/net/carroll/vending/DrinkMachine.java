package net.carroll.vending;

import java.math.BigDecimal;
import java.util.List;

import net.carroll.vending.data.LoadedProduct;

public class DrinkMachine  extends VendingMachineBase implements VendingMachineInterface {

			
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
