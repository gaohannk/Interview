package google;

import java.util.Stack;

/*给你一个文件列表，找出所有图片文件的路径长度总和。
比如说：
dir1
 dir11
 dir12
  picture.jpeg
  dir121
  file1.txt
dir2
 file2.gif
图片的路径为：
/dir1/dir12
/dir2
 11+6=17
 */
public class LongestImageFilePathII {
	public static int solution(String S) {
		String[] split = S.split("\n");
		Stack<String> stack = new Stack<>();
		int total = 0;
		int current = 0;
		// Flag for weather the fig file in the same dirctorary.
		boolean flag = false;
		int lastLevel = 0;
		for (int i = 0; i < split.length; i++) {
			int level = getLevel(split[i]);
			if (level != lastLevel) {
				flag = false;
			}
			while (stack.size() >= level) {
				current -= (stack.pop().trim().length() + 1);
			}
			lastLevel = level;
			System.out.println(split[i]);
			if (isImage(split[i]) && !flag) {
				flag = true;
				System.out.println(current);
				// Corner case /file.png
				if (level == 1)
					total++;
				total += current;
			}
			current += split[i].trim().length() + 1;
			stack.push(split[i]);
		}
		return total;
	}

	public static boolean isImage(String str) {
		if (str.contains(".jpeg") || str.contains(".png") || str.contains(".gif"))
			return true;
		return false;
	}

	public static int getLevel(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				count++;
		}
		return count + 1;
	}

	public static void main(String[] args) {
		String S = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.png\ndir2\n file2.gif\n dir3\n  file3.gif\n";
		String SS = "file.png\npic.gif\ndir1\n file1.gif\n";
		System.out.println(solution(SS));
	}
}
