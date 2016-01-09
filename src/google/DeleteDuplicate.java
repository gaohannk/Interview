package google;

import java.util.ArrayList;
import java.util.HashSet;

/* String 数组去重，但是保留原来的顺序
 * ['a','b','a','c'] => ['a','b','c']
 */
public class DeleteDuplicate {
	public static String[] deleteDuplicat(String[] strs) {
		HashSet<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<String>();
		for (String s : strs) {
			if (!set.contains(s)) {
				set.add(s);
				list.add(s);
			}
		}
		return (String[]) list.toArray();
	}
	public static void main(String[] args) {
		String[] strs={"a","b","a","c"};
		String[] res=deleteDuplicat(strs);
		
	}
}
