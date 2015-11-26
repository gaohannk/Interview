package epic;
/* A number is called as a stepping number if the adjacent digits are having adifference of 1. 
 * For eg. 8, 343, 545 are stepping numbers. While 890, 098 are not. 
 * The difference between a ‘9’ and ‘0’ should not be considered as 1. 
 * Given start number(s) and an end number (e) your function should list out all the stepping numbers 
 * in the range including both the numbers s & e.
 */
public class SteppingNumber2 {
	 public static void findSteppingNum(int start, int end){
	    	for(int i=start;i<=end;i++){
	    		if(isStepNumByString(i))
	    			System.out.println(i);
	    	}
	    }
	private static boolean isStepNumByString(int num) {
		String str=Integer.toString(num);
		for(int i=1;i<str.length();i++){
			if(Math.abs(str.charAt(i)-str.charAt(i-1))!=1)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		findSteppingNum(1, 100000);
	}
}
