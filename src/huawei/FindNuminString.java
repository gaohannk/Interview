package huawei;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class FindNuminString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str=scan.nextLine();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>='0'&&str.charAt(i)<='9')
				list.add(Integer.parseInt(""+str.charAt(i)));
		}
		Collections.sort(list);
		String res="";
		for (int i=0;i<list.size();i++){
			res+=list.get(i);
		}
		System.out.println(res);
		scan.close();
	}
}
