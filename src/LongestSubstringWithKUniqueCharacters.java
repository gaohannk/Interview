/* 
 * The problem can be solved in O(n). 
 * Idea is to maintain a window and add elements to the window till it contains less or equal k, 
 * update our result if required while doing so. 
 * If unique elements exceeds than required in window, start removing the elements from left side.
 */

public class LongestSubstringWithKUniqueCharacters {

	// This function calculates number of unique characters
	// using a associative array count[]. Returns true if
	// no. of characters are less than required else returns
	// false.
	public static boolean isValid(int count[], int k) {
		int val = 0;
		for (int i = 0; i < 26; i++)
			if (count[i] > 0)
				val++;
		// Return true if k is greater than or equal to val
		return (k >= val);
	}

	// Finds the maximum substring with exactly k unique chars
	public static String kUniques(String s, int k) {
		int u = 0; // number of unique characters

		// Associative array to store the count of characters
		int count[] = new int[26];

		// Traverse the string, Fills the associative array
		// count[] and count number of unique characters
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i) - 'a'] == 0)
				u++;
			count[s.charAt(i) - 'a']++;
		}
		if (u < k)
			return "";

		// Otherwise take a window with first element in it.
		// start and end variables.
		int curr_start = 0, curr_end = 0;

		// Also initialize values for result longest window
		int max_window_start = 0, max_window_end = 0;
		int max_window_size = 1;
		count[s.charAt(0) - 'a']++; // put the first character

		// Start from the second character and add
		// characters in window according to above
		// explanation
		for (int i = 1; i < s.length(); i++) {
			// Add the character 's[i]' to current window
			count[s.charAt(i) - 'a']++;
			curr_end++;

			// If there are more than k unique characters in
			// current window, remove from left side
			while (!isValid(count, k)) {
				count[s.charAt(i) - 'a']--;
				curr_start++;
			}
			// Update the max window size if required
			if (curr_end - curr_start + 1 > max_window_size) {
				max_window_end = curr_end;
				max_window_start = curr_start;
			}
		}
		return s.substring(max_window_start, max_window_end);
	}

	// Driver function
	public static void main(String[] args) {
		String s = "aabacbebebe";
		int k = 3;
		System.out.println(kUniques(s, k));
	}
}
