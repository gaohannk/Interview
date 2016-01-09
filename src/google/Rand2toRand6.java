package google;

import java.util.Random;

public class Rand2toRand6 {
	public int rand6(){
		 while(true){
		 int num=2*(rand4()-1)+rand2();
		 if(num<6)
				return num +1; 
		 }
	 }

	public int rand4() {
		return 2 * (rand2() - 1) + rand2();
	}

	public int rand2() {
		Random rand = new Random();
		return rand.nextInt();
	}
}
