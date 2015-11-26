package epic;
/* Goldbach's conjecture : Every even integergreater than 2 can be expressed as the sum of two primes.
 * Write a functionwhich takes a number as input, verify if is an even number greater than 2 and 
 * also print at least one pair of prime numbers.
 */

public class GoldbachConjecture {
	public static void findPrimePair(int num) {
		if (num % 2 != 0 || num <= 2)
			return;
		for (int i = 2; i < num / 2; i++) {
			if (isPrime(i) && isPrime(num - i)) {
				System.out.println("Goldbach numbers are :" + i + " plus " + (num - i) + " equal " + num);
				return;
			}
		}
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i * i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		findPrimePair(14);
	}
}
