package net.carroll.vending.data;

import java.math.BigDecimal;

public class Product {

	private String name;
	private int size;
	private BigDecimal basePrice;
	
	
	public Product() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public BigDecimal getBasePrice() {
		return basePrice;
	}


	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
	

}
