package epic;

/* A random generator (like a speaker standing in a group housie game calls out a number) 
 * generates out any number from 1 to 1000. 
 * There is a 10X10 matrix. 
 * A random generator assigns values to each block of this matrix.
 * Whenever, a row or a column or a diagonal is fully filled in this 10x10 from the numbers called out 
 * by the speaker, its called a 'Mingo'. 
 * Write a program that will find first Mingo, then second Mingo, then thirds Mingo...and so forth.
 */
public class Mingo {
	static int[][] matrix = new int[10][10];
	static int count = 0;
	static boolean diag = false, rediag = false;

	static void initial() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	static void printMingle() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void isMingo(int[][] matrix) {
		int value = 0;
		int row = 0;
		int col = 0;
		int data = 0;
		for (int i = 0; i < 100; i++) {
			while (matrix[row][col] != 0) {
				value = (int) (Math.random() * 100);
				row = value / 10;
				col = value - row * 10;
			}
			data = (int) (Math.random() * 1000);
			matrix[row][col] = data;
			checkMingle(matrix, row, col);
		}
	}

	public static void checkMingle(int[][] matrix, int row, int col) {
		int index = 0;
		while (index < 10 && matrix[row][index] != 0) {
			index++;
		}
		if (index == 10) {
			count++;
			System.out.println("Number " + count + "th mingo " + "row: " + row);
		}
		index = 0;
		while (index < 10 && matrix[index][col] != 0) {
			index++;
		}

		if (index == 10) {
			count++;
			System.out.println("Number " + count + "th mingo " + "col: " + col);
		}
		index = 0;
		while (index < 10 && matrix[index][index] != 0) {
			index++;
		}
		if (index == 10) {
			count++;
			System.out.println("Number " + count + "th diag  mingo!!!!!!!!!");
			diag = true;
		}
		index = 0;
		while (index < 10 && matrix[index][9 - index] != 0) {
			index++;
		}
		if (index == 10) {
			count++;
			System.out.println("Number " + count + "th rediag mingo!!!!!!!!!!!!! ");
			rediag = true;
		}
	}

	public static void main(String[] args) {
		initial();
		isMingo(matrix);
		printMingle();
	}
}
