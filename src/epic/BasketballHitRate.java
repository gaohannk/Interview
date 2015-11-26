package epic;

import java.text.DecimalFormat;

/* The hit rate of the basketball game is given by the number of hits divided by the number of chances. 
 * For example, you have 73 chances but hit 15 times, then your hit rate is 15/73=0.205 (keep the last 3 digits). 
 * On average, you have 4.5 chances in each basketball game. Assume the total number of games is 162. 
 * Write a function for a basketball player. 
 * He will input the number of hits he has made, the number of chances he had, and the number of remaining games. 
 * The function should return the number of future hits, so that he can refresh his hit rate to 0.45
 */
/* 0.45 = (hit + x) / (chance + remain * 4.5) 
 */
public class BasketballHitRate {

	public static String gethitrate(int hit, int chance, int remain) {
		double currate = (double) hit / (double) chance;
		System.out.println(currate);
		DecimalFormat df = new DecimalFormat("#.000");
		double res= 0.45 * (chance + remain * 4.5) - hit;
		return df.format(res);
	}

	public static void main(String[] args) {
		System.out.println(gethitrate(100, 250, 3));
	}
}
