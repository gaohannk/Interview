package google;

/* Imagine automated car that only moves forward and reverse in a straight line.
 * Car can be pre-programmed with a sequence of two instructions:
 * Accelerate: move forward for one unit of time at current speed, then double the speed.
 * Reverse: change direction (forward to reverse or reverse to forward), but do not move, then reset your speed to 1
 * The initial speed is 1, pointing forward.
 * E.g., sequence A moves the car from position at 0 to position at 1.
 * E.g., sequence A A moves the car from position at 0 to position at 3 ( = 1 + 2).
 * E.g., sequence A A A moves the car from position at 0 to position at 7 ( = 1 + 2 + 4).
 * E.g., sequence A A R A moves the car from position at 0 to position at 2 ( = 1 + 2 - 1).
 * E.g., sequence A A A A A R A A A R A  moves the car to position 25 (= 1 + 2 + 4 + 8 + 16 - 1 - 2 - 4 + 1).
 * Write the function int drive(String seq) which, given a sequence, calculates how far the car will move.
 * Write the inverse function String driveTo(int dist) - given a distance, return a sequence that will move that far.
 */
public class MotorCar {

	public static int drive(String seq) {
		if (seq == null || seq.length() == 0)
			return 0;
		long sum = 0; 
		int speed = 1;
		boolean direction = true;
		for (int i = 0; i < seq.length(); i++) {
			if (seq.charAt(i) == 'A') {
				if (direction)
					sum += speed;
				else
					sum -= speed;
				speed *= 2;
			} else if (seq.charAt(i) == 'R') {
				speed = 1;
				direction = direction == true ? false : true;
			}
		}
		return (int) sum;
	}

	public static String driveTo(int dist) {
		String res = "";
		int sum = 0;
		int speed = 1;
		boolean direction = true;
		boolean flag = false;
		while (dist != sum) {
			if (direction) {
				sum += speed;
				speed *= 2;
				res += 'A';
				flag = true;
			} else {
				sum -= speed;
				res += 'A';
				speed *= 2;
				flag = false;
			}
			if (flag && sum > dist) {
				direction = direction == true ? false : true;
				res += 'R';
				speed = 1;
				flag = false;
			}
			if (!flag && sum < dist) {
				direction = direction == true ? false : true;
				res += 'R';
				speed = 1;
				flag = true;
			}
		}
		return res;
	}
	public static void main(String[] args){
		System.out.println(drive("AARRRAARA"));
		System.out.println(driveTo(24));
	}
}
