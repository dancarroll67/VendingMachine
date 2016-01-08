package net.carroll.vending.data;

public class LoadedProductBuilder {

		int id=0;
		Product p = new Product();
		//optional
		int row=0;
		int column=0;
		int spot=0;
		int price=0;
	
		
		public LoadedProductBuilder(int id, Product product) {
			this.p = product;
			this.id = id;
		}
		public LoadedProductBuilder row(int val) {
			row=val;
			return this;
		} 
	
		public LoadedProductBuilder column(int val) {
			row=val;
			return this;
		} 
		public LoadedProductBuilder spot(int val) {
			row=val;
			return this;
		} 
		public LoadedProductBuilder price(int val) {
			row=val;
			return this;
		} 

}
