package yapstone;

import java.util.Scanner;

public class ReformatData {
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String line = sc.nextLine();
		String split[] = line.split(" ");
		int col = Integer.parseInt(split[0]);
		int row = num - 1 / col;
		int mat[][] = new int[row][col];
		for (int i = 1; i < num; i++) {
			int rowindex = i - 1 / col;
			int colindex = i - 1 % col;
			mat[rowindex][colindex] = Integer.parseInt(split[i]);
		}
		int query = sc.nextInt();
		sc.nextLine();
		while (query-- > 0) {
			String indexs = sc.nextLine();
			String[] indexsplit = indexs.split(" ");
			int queryrow = Integer.parseInt(indexsplit[0]);
			int querycol = Integer.parseInt(indexsplit[1]);
			System.out.println(mat[queryrow][querycol]);
		}
	}
}
