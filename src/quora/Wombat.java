package quora;

import java.util.LinkedList;
import java.util.Scanner;

public class Wombat {

	public static void main(String args[]) throws Exception {

		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int res = Integer.MIN_VALUE;
		LinkedList<LinkedList<LinkedList<Integer>>> all = new LinkedList<LinkedList<LinkedList<Integer>>>();
		scan.nextLine();
		for (int i = 0; i < length; i++) {
			LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
			int count = i + 1;
			while (count-- > 0) {
				String str = scan.nextLine();
				String[] split = str.split(" ");
				LinkedList<Integer> line = new LinkedList<Integer>();
				for (int j = 0; j < split.length; j++) {
					line.add(Integer.parseInt(split[j]));
				}
				list.add(line);
			}
			all.add(list);
		}
		int sum = 0;
		for (int k = 0; k < length; k++) {
			for (int i = k; i < length; i++) {
				LinkedList<LinkedList<Integer>> list = all.get(i);
				for (int j = 0; j < list.size() - k; j++) {
					LinkedList<Integer> line = list.get(j);
					sum += line.get(line.size() - (k + 1));
				}
				if (sum > res)
					res = sum;
			}
		}
		sum = 0;
		for (int k = 0; k < length; k++) {
			for (int i = k; i < length; i++) {
				LinkedList<LinkedList<Integer>> list = all.get(i);
				for (int j = 0; j < list.size() - k; j++) {
					LinkedList<Integer> line = list.get(j);
					sum += line.get(k);
				}
				if (sum > res)
					res = sum;
			}
		}

		sum = 0;
		for (int k = 0; k < length; k++) {
			for (int i = k; i < length; i++) {
				LinkedList<LinkedList<Integer>> list = all.get(i);
				LinkedList<Integer> line = list.get(k);
				for (int j = 0; j < line.size(); j++) {
					sum += line.get(j);
				}
				if (sum > res)
					res = sum;
			}
		}

		sum = 0;
		for (int i = 0; i < length; i++) {
			LinkedList<LinkedList<Integer>> list = all.get(i);
			for (int j = 0; j < list.size(); j++) {
				LinkedList<Integer> line = list.get(j);
				for (int k = 0; k < line.size(); k++) {
					sum += line.get(k);
				}
			}
			if (sum > res)
				res = sum;
		}
		System.out.println(res);
	}
}
