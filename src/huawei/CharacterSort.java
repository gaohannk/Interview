package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class CharacterSort {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		char[] chars = new char[line.length()];
		for(int i=0;i<chars.length;i++){
			chars[i]=line.charAt(i);
		}
		Arrays.sort(chars);
		for(int i=0;i<chars.length;i++){
			System.out.print(chars[i]);
		}
	}
}
