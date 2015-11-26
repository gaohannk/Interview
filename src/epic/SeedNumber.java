package epic;

/* Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. find all possible seed for a given number.
 */
/* seeds must be between sqrt(n) and n/2
 */
import java.util.LinkedList;
import java.util.List;

public class SeedNumber {
	public static List<Integer> seedNum(int num) {
		List<Integer> seeds = new LinkedList<Integer>();
		if (num == 0 || num == 1) {
			seeds.add(num);
			return seeds;
		}
		if (num < 4)
			return seeds;
		for (int i = (int) Math.sqrt(num); i <= num / 2; i++) {
			if (num % i == 0) { 
				int temp = i;
				int res = i;
				while (temp != 0) {
					res *= temp % 10;
					temp = temp / 10;
				}
				if (res == num)
					seeds.add(i);
			}
		}
		return seeds;
	}
	public static void main(String[] args){
		List<Integer> list= seedNum(1716);
		for(int i:list){
			System.out.println(i);
		}
	}
}
