package alibaba;


public class findNumber {

	public static long findNumberFromArray(long[] array){
	    long result = 0;
	    for(int i=0;i<array.length;i++){
	        result^=array[i];
	    }
	    return result;
	}
	public static void main(String[] args){
		long[] array={88, 459, 5262, 88, -17, 677, 88, 677, -17, 459, 5262};
		System.out.println(findNumberFromArray(array));
	}

}
