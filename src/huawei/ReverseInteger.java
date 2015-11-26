package huawei;


import java.util.Scanner;

public class ReverseInteger {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		String str= String.valueOf(num);
		String newstr="";
		int stop=0;
		if(num<0){
			newstr+="-";
			stop=1;
		}
		for(int i=str.length()-1;i>=stop;i--){
			newstr+=str.charAt(i);
		}
		System.out.println(Integer.parseInt(newstr));
		scan.close();
	}
}
