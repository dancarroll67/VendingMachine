package net.carroll.vending.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.carroll.vending.SnackMachine;
import net.carroll.vending.VendingMachineBank;
import net.carroll.vending.data.LoadedProduct;
import net.carroll.vending.data.LoadedProductBuilder;
import net.carroll.vending.data.Product;
import net.carroll.vending.data.VendingMachineActionEnum;
import net.carroll.vending.factory.VendingMachineFactory;
import net.carroll.vending.state.VendingMachineState;

public class BaseTest {

	public BaseTest() {
		
	}

	//Create vm
	//load products to vm
	//load money to vm
	//put in money
	//get product and change or error message 
	//back to ready state
	
	
	public static void main(String[] args) {
		//make the vending machine		
		SnackMachine sm = VendingMachineFactory.getSingleton().getSnackMachine();
		sm.setBank(new VendingMachineBank());
		sm.setVmId(100);
		
		//1st test, customer can't use yet as it's in new state (not ready)
		System.out.println(" the machine state: "+ sm.getMachineState().toString());
		System.out.println("  button pressed allowed: " +sm.getMachineState().actionAllowed(VendingMachineActionEnum.BUTTONPRESSED));

		//load money
		sm.loadBankMoney(new BigDecimal(25.50));
		
		//load products
		List<LoadedProduct> l = new ArrayList<LoadedProduct>();
		l.add(getLoadedProduct());
		sm.loadProducts(l);
		
		//ready to go
		
		sm.takeMoney(new BigDecimal(1.50));
	 
		int result = sm.buttonPressed();
		
		if (result == 0) {
			System.out.println(" product vended");
		} else {
			System.out.println(" product not vended");
		}
		
	}
	
	private static LoadedProduct getLoadedProduct() {
		Product p = new Product();  //get something from product factory
		p.setBasePrice(new BigDecimal(1.5));
		p.setName("bigsoda");
		p.setSize(3);
		LoadedProductBuilder b = new LoadedProductBuilder(55, p);
		b.row(0).column(0).spot(0);
		LoadedProduct lp = new LoadedProduct(b);
		return lp;
	}

}
