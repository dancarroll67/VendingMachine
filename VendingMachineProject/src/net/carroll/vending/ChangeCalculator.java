package net.carroll.vending;

import java.util.Arrays;

public class ChangeCalculator {

	//http://stackoverflow.com/questions/7067044/java-algorithm-to-solve-vendor-machine-change-giving-problem
	public static void main(String[] args) {
				 
		vendingMachine();
		
//		 System.out.println(sum(1));
//		 System.out.println("\n");
//		 System.out.println("\n");
//		 System.out.println(sum(25));
		 
		//printAll(3, new int[] {10,5,1}, 0, new int[] {3,2,1});
		System.out.println("\n");
		
		//printAll(0, new int[] {10,5,1}, 1, new int[] {3,2,1});

	}
	
	public static void printAll(int ind, int[] denom,int N,int[] vals){
		System.out.println("printall start");
	    if(N==0){
	        System.out.println(Arrays.toString(vals));
	        return;
	    }
	    if(ind == (denom.length))return;  
	    
	    int currdenom = denom[ind];
	    
	    for(int i=0;i<=(N/currdenom);i++){
	        vals[ind] = i;
	        printAll(ind+1,denom,N-i*currdenom,vals);
	    }
	 }
	
	   public static int sum(int n) {

	        int count = 0;
	        for (int i = 0; i <= n / 25; i++) {
	            for (int j = 0; j <= n / 10; j++) {
	                for (int k = 0; k <= n / 5; k++) {
	                    for (int l = 0; l <= n; l++) {
	                        int v = i * 25 + j * 10 + k * 5 + l;
	                        if (v == n) {
	                        	 System.out.println("adding to count:" + i+":"+ j+":"+k+":"+l);
	                            count++;
	                        } else if (v > n) {
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	        return count;
	    }

	   public static final int[] coins = {1, 5, 10, 25};
	    public static final int[] coinMax = {200, 40, 20, 8};
	   // public static final int[] coinsString = { "Penny", "Nickle", "Dime", "Quarter"};

	  


	    public static void vendingMachine()
	    {
	        for ( int a = 0; a <= coinMax[0]; a++ ) {
	            for ( int b = 0; b <= coinMax[1]; b++ ) {
	                for ( int c = 0; c < coinMax[2]; c++ ) {
	                    for ( int d = 0; d < coinMax[3]; d++ ) {
	                        checkCoins(a, b, c, d);
	                    }
	                }
	            }
	        }
	    }

	    public static void checkCoins(int penny, int nickle, int dime, int quarter)
	    {
	        int total = coins[0] * penny + coins[1] * nickle + coins[2] * dime + coins[3] * quarter;

	        if ( total == 200 )
	            printCoins(penny, nickle, dime, quarter);

	    }

	    public static void printCoins(int penny, int nickle, int dime, int quarter)
	    {
	        System.out.println("Penney : " + penny + " Nickle: " + nickle + " Dime: " + dime + " Quarter: " + quarter);
	    }	

}
