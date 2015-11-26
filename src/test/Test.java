package test;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

/*	public int add(int a, int b) {
		try {
			return a + b;
		} catch (Exception e) {
			System.out.println("catch语句块");
		} finally {
			System.out.println("finally");
		}
		return 0;
	}*/
	public class MyClass
	{
	  private int a;
	  public double b;
	  
	  public MyClass(int first, double second)
	  {
	    this.a = first;
	    this.b = second;
	  }
	  public static void main(String[] args)
	  {
	    MyClass c1 = new MyClass(10, 20.5);
	    MyClass c2 = new MyClass(10, 31.5);
	    // lines below are changed from the question above
	    c2 = c1;   
	    c1.a = 2;
	    System.out.println(c2.a);
	  }
	}
	//public static void main(String argv[]) {
		/*Test test = new Test();
		System.out.println("和是：" + test.add(9, 34));

		pair a = new pair();
		pair b = new pair();
		pair c = new pair();
		a.val = 1;
		a.val2 = 0;
		b.val = 2;
		b.val2 = 1;
		c.val=3;
		c.val2=5;
		pair[] array = new pair[3];
		array[0] = a;
		array[1] = b;
		array[2] = c;
		Arrays.sort(array, new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				System.out.println("hahaha");
				if (o1.val < o2.val)
					return -1;
				else if (o1.val > o2.val)
					return 1;
				return 0;
			}
		});
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].val);
		}*/

	}
}
class pair {
	int val;
	int val2;
}
