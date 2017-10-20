package arrays;

import java.util.Arrays;

public class PassByValueExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello";
		Person p = new Person("Random","Dude",Borough.NY_BOROUGHS[0]);
		int x = 5;
		int [] arr = {1,2,3};

(p,x,arr);
		System.out.println("ha" +p+"" + x+Arrays.toString(arr));
	}
	// primitive data can not be reference 
	private static void test1(Person p, int x, int[] arr) {
		p.setFirstName("Original");	
		arr[0] = 999;
		arr[1] = 994;
	}

	private static void changeEVERYTHING(String s, int x, int[] arr) {
		s = "Goodbye";
		x = -5;
		arr[0]= -1;
		arr[1] = -2;
		arr[2] = -3;
	}

}
