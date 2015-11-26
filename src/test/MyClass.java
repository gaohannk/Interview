package test;
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
