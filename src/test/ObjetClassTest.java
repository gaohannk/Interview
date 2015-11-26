package test;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ObjetClassTest {

	public static ArrayList<Jobinfo> list = new ArrayList<Jobinfo>();
	
	public static  void test(){
		Jobinfo job1= new Jobinfo();
		System.out.println(job1.jobid2);
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		System.out.println(list.size());
		list.remove(0);
		System.out.println(list.size());
	}

}
