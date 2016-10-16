package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionSort {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] splits = line.split(" ");
		if(splits.length==1){
			System.out.println(splits[0]);
			return;
		}
		int evens[] = new int[splits.length / 2];
		int len = 0;
		if (splits.length % 2 == 0) {
			len = splits.length / 2;
		} else {
			len = splits.length / 2+1 ;
		}
		int odds[] = new int[len];
		for (int i = 0; i < splits.length; i = i + 2) {
			odds[i / 2] = Integer.parseInt(splits[i]);
		}
		for (int i = 1; i < splits.length; i = i + 2) {
			evens[(i - 1) / 2] = Integer.parseInt(splits[i]);
		}
		Arrays.sort(odds);
		Arrays.sort(evens);
		for (int i = 0; i < splits.length; i++) {
			if (i % 2 == 0)
				System.out.print(odds[i/2]+" ");
			else
				System.out.print(evens[evens.length - 1 - (i - 1) / 2]+" ");
		}
	}
}
