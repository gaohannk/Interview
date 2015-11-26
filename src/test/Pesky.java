package test;

import javax.naming.spi.DirStateFactory.Result;

public class Pesky {

	public static int getpesky(int n) {
		int r = 0;
		for (int i = 1; i < n; i++)
			for (int j = 1; j < i + 1; j++)
				for (int k = j; k < i + j + 1; k++)
					r++;
		int result= n*(n+1)*(2*n+1)/6-n*(n+1)/2;
		System.out.println(result);
		return r;
		
	}
	
	public static void main(String[] args){
		System.out.println(getpesky(20));
	}

}
