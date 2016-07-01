package samsung;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

/* 给一个non-empty array, 判断能不能swap其中两个位置的数字，使其成为sorted array
 * 比如input 1,5,3,3,7, swap 5和3就可以，返回true, 但是1,7,3,3,5 返回 false
 * 
 */
public class CanbeSortedArray {
//	public boolean canbeSortedArray(int nums[]) {
//		boolean flag = false;
//		int swap1 = 0;
//		int bufbefore = 0;
//		int bufafter = 0;
//		for (int i = 0; i < nums.length - 1; i++) {
//			if (!flag && nums[i + 1] < nums[i]) {
//				swap1 = nums[i];
//				bufbefore = nums[i + 1];
//				if (i > 0)
//					bufafter = nums[i - 1];
//				flag = true;
//			}
//			if (nums[i] > swap1 && nums[i - 1] <= bufafter && nums[i - 1] >= bufbefore) {
//			HashMap<Integer, Integer> 	
//			}
//		}
//	}

		public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
			ArrayList<Integer> arrayList3=new ArrayList<Integer>();
			arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
			arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
			for (int i=0;i<arrayList3.size();i++) {
				System.out.println(arrayList3.get(i));
			}
		}
}
