package epic;

public class AddtiveNumber {

	public static void main(String[] args) {
		System.out.println(isAdditiveNumber("121224"));
		System.out.println(isAdditiveNumber("112358"));
		System.out.println(isAdditiveNumber("1910"));

	}

	public static boolean isAdditiveNumber(String number) {
		for (int i = 1; i < number.length(); i++) {
			for (int j = i + 1; j < number.length(); j++) {
				int part1_tmp = Integer.parseInt(number.substring(0, i));
				int part2 = Integer.parseInt(number.substring(i, j));
				int index = j;
				int rest = Integer.parseInt(number.substring(j, number.length()));
				while (part1_tmp + part2 <= rest) {
					int part3 = part1_tmp + part2;
					String str = Integer.toString(part3);
					int length = str.length();
					if (index + length > number.length()) {
						break;
					}
					if (number.substring(index, index + length).equals(str)) {
						index = length + index;
						if (index == number.length()) {
							return true;
						}
						part1_tmp = part2;
						part2 = part3;
						rest = Integer.parseInt(number.substring(index, number.length()));
					} else {
						break;
					}
				}
			}
		}
		return false;

	}
}
