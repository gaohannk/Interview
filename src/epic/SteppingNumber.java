package epic;

/* A number is called as a stepping number if the adjacent digits are having adifference of 1. 
 * For eg. 8, 343, 545 are stepping numbers. While 890, 098 are not. 
 * The difference between a ‘9’ and ‘0’ should not be considered as 1. 
 * Given start number(s) and an end number (e) your function should list out all the stepping numbers 
 * in the range including both the numbers s & e.
 */
public class SteppingNumber {
    public static void findSteppingNum(int start, int end){
    	for(int i=start;i<=end;i++){
    		if(isStepNumByNum(i))
    			System.out.println(i);
    	}
    }
	private static boolean isStepNumByNum(int num) {
		int lastdigit=(int) num%10;
		while(num>10){
			num=num/10;
			int digit= (int) (num%10);
			if(Math.abs(lastdigit-digit)!=1)
				return false;
			lastdigit=digit;
		}
		return true;
	}
}
