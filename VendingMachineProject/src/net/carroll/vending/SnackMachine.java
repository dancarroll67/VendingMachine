package net.carroll.vending;

import java.math.BigDecimal;
import java.util.List;

import net.carroll.vending.data.LoadedProduct;
import net.carroll.vending.state.MoneyInState;
import net.carroll.vending.state.NewState;
import net.carroll.vending.state.ReadyState;
import net.carroll.vending.state.VendingMachineState;

public class SnackMachine extends VendingMachineBase implements VendingMachineInterface, Cloneable {

	
	public void loadBankMoney(BigDecimal total) {
		this.getBank().setTotalAmount(total);
		this.setMachineState(new ReadyState());
	}
	public void loadProducts(List<LoadedProduct> products) {
		//set these to the vending machine
		this.setMachineState(new ReadyState());
	}
	
	public void takeMoney(BigDecimal bd) {
		this.setMachineState(new MoneyInState());
	} ;
	
	public int buttonPressed(int buttonID) {
		return 0;  //success
	}
	
	public void vendProduct() {		
		
	};
	public void giveChange() {}
	
	
  @Override
    public  Object clone() throws CloneNotSupportedException {
	  SnackMachine cloned = (SnackMachine)super.clone();
	  cloned.setBank((VendingMachineBank)cloned.getBank().clone());
	  return cloned;
    }
	
}
