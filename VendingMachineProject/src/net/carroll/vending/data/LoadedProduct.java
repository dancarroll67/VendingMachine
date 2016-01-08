package net.carroll.vending.data;

public class LoadedProduct {

	private Product product;
	private int row;
	private int column;
	private int spot;
	private int price;
	
	
	public LoadedProduct(LoadedProductBuilder builder) {
		super();
		if (builder == null) {
			return;  //error?			
		}
		product=builder.p;  //deepcopy?
		row=builder.row;
		column=builder.column;
		spot=builder.spot;
		price=builder.price;		
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(" product" + product.toString());
		sb.append("\n row: " + row);
		sb.append("\n col: " + column);
		sb.append("\n spot: " + spot);
		sb.append("\n $" + product.getBasePrice());
		sb.append("\n $" + price);
		return sb.toString();
	}
	
	
}
