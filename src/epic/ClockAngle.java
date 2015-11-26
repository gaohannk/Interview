package epic;

/* We are given a specific time(like 02:23), we need to get the angle between hour and minute(less than 180)
 * 
 */
public class ClockAngle {

	public static double CalulateAngle(String time) {
		String[] part = time.split(":");
		int hour = Integer.parseInt(part[0]);
		int minute = Integer.parseInt(part[1]);
		double angle = Math.abs(6 * minute - (30 * hour + 0.5 * minute));
		if (angle > 180)
			return 360 - angle;
		else
			return angle;
	}

	public static void main(String[] args) {
		String time = "12:15";
		System.out.println(CalulateAngle(time));
	}
}
