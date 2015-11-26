package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EntryTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(321, "c1c");
		map.put(134, "aa");
		map.put(2, "2bb");
		
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
		//Collections.sort(map.entrySet());
		System.out.println("hello");
	}
}
