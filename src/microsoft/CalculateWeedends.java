package microsoft;

/* Given the start date of the year, given the total days of the year. 
 * How many weekend days? (Sat and Sun)
 */
public class CalculateWeedends {
	public static int getWeedkendsDays(int start, int total) {
		int remain = total % 7;
		int week = total / 7;
		int count = week * 2;
		for (int i = 0; i < remain; i++) {
			// (start+i)%7==0 not 7
			if ((start + i) % 7 == 6 || (start + i) % 7 == 0) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] arg) {
		System.out.println(getWeedkendsDays(5, 367));
	}
}
