package pocketgems;

import java.util.Arrays;

public class FindkFrequencyNumber2 {
	public static int[] findkfrequencynumber(int[] num,int k){
		 Arrays.sort(num);
		 int[] res= new int[k];
		 int index=1;
		 res[0]=num[num.length-1];
		 for(int i=num.length-1;i>0;i--){
			if(num[i]!=num[i-1]){
				res[index]=num[i-1];
				index++;
			}
			if(index==k)
				break;
		 }
		 return res;
	}
     public static void main(String[] args){
 		int[] num={1,1,1,8,4,8,8,5,5,5,8,1,1,8,4,1,1,3};
 		int[] res=findkfrequencynumber(num, 3);
 		for(int i=0;i<res.length;i++){
 			System.out.println(res[i]);
 		}
     }
}
