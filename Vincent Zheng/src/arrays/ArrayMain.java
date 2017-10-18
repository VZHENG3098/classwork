package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMain {

	private int[] testArray;
	private String[] suits;
	private String[] values;
	
	
	
	public ArrayMain() {
		
		//suits = new String[4];
		//suits[0] = "Diamonds";
		//suits[1] = "Clubs";
		//suits[2] = "Hearts";
		//suits[3] = "Spades";
		//values = new String[13];
		//for(int i=0; i<values.length; i++)
		//{
		//	values[i] = ""+(i+1);
			
		//}
		//values[0] = "Ace";
		//values[12] ="King";
		//values[11] ="Queen";
		//values[10] ="Jack";
		//printDeck();
		
		warmUpMethods();
		wednesdayMethods();
		//testArray = new int[5];
		//populate(testArray);
		//populate1ToN(testArray);
		
		//shuffle(testArray);
		//countOccurences(testArray,2,12);
		
		//reverseOrder(testArray);
		
		//System.out.println(Arrays.toString(testArray));
	}
	
	private void wednesdayMethods() {
		int[] diceRolls = new int[10000000];
		populate(diceRolls);
		int[] data = longestConsecutiveSeqAndindex(diceRolls);
		int longest = data[0];
		System.out.println(data[0] +" happen at " + data[1] + " sequence was "+ Arrays.toString(subArray(diceRolls,data[1],data[0])));
		while(longest != 9) {
			 diceRolls = new int[100000];
			populate(diceRolls);
			 data = longestConsecutiveSeqAndindex(diceRolls);
			 longest = data[0];
			System.out.println(data[0] +" happen at " + data[1] + " sequence was "+ Arrays.toString(subArray(diceRolls,data[1],data[0])));
		}
	}
	private int[] longestConsecutiveSeqAndindex(int[] arr) {
		int[] data = new int[2];//element at zero is length, at 1 is position
		data[0] = 1;
		int currentnum = 1;
		for(int i = 0; i < arr.length-1;i++) {
			if(isConsecutive(arr,i,i+1)) {
				currentnum++;
				if(currentnum > data[0]) {
					data[0] = currentnum;
					data[1] = i-currentnum;
				}
			}else {
				currentnum = 1;
			}
		}
		return data;
	}
	
	
	
	
	
	

	private int longestConsecutiveSequence(int[] arr) {
		int num = 1;
		int highnum = 1;
		for(int i = 0; i < arr.length-1;i++) {
			if(isConsecutive(arr,i,i+1)) {
				num ++;
				if(num > highnum) {
					highnum = num;
				}
			}else {
				num = 1;
			}
		}
		return highnum;
	}
	private boolean isConsecutive(int[] arr,int start, int end) {
		boolean check = false;
		if(arr[start]+1 == arr[end]) {
			check = true;
		}
		return check;
	}
	
	private void frontToBack(int[] arr) {
		int [] saved = arr;
		int x = arr[0];
		for(int i = 0 ; i< arr.length-1; i++) {
			arr[i] = saved[i+1];
		}
		arr[arr.length-1] = x;
	}
	
	private void cycleThrough(int[] orderTest, int n) {
		for(int i = 0; i<n;i++) {
			frontToBack(orderTest);
		}
	}
	
	private void warmUpMethods() {
		int[] orderTest = {1,2,3,4,5,6,7,8,9,10};
		reverseOrder(orderTest);
		System.out.println(Arrays.toString(orderTest));
		System.out.println(Arrays.toString(subArray(orderTest,3,4)));
	}
	
	
	private void reverseOrder(int [] arr)
	{
		 for(int i=0; i<arr.length/2; i++)
		 {
			 swap(arr,i,arr.length-1-i);
		 }
	
	}
	private int[] subArray(int[] arr,int psn,int length) {
		int[] sub = new int[length];
		for(int i = 0; i< length; i++) {
			sub[i] = arr[i+psn];
		}
		return sub;
	}
	
	
	private void printDeck()
	{
		for(String suit: suits)
		{
			for(String values: values)
			{
				System.out.println(values + " of "+suit);
			}
		}
		
	}
	
	private void countOccurences(int[] arr, int start, int end)
	{
		int[] counter = new int[end-start+1];
		for(int value: arr) 
		{
			counter[value-start]++;
		}
		for(int i=0; i<counter.length; i++)
		{
			System.out.println("The value "+(i+start)+" was rolled "+counter[i]+" times");
		}
	}
	
	
	private void shuffle(int[] arr) {
		for(int i= 0; i<arr.length; i++) 
		{
			swap(arr,i,(int)(Math.random()*arr.length));
		}
	
	}
	
	private void swap(int[] arr, int i, int j)
	{
		int placeholder = arr[i];
		arr[i] = arr[j];
		arr[j] = placeholder;
	}
	
	private void populate1ToN(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			arr[i]=(i+1);
		}
	}
	
	
	private void populate(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = diceRoll(2);
		}

		
	}
	
	
	public void arrayNotes()
	{
		//two ways to make an array
		int[] firstWay = {0,1,2,3,4,5};
		
		String[] secondWay = new String[5];
		//secondWay[0] = 1;
		//secondWay[1] = 10;
		
		//TWO WAYS TO ITERATE THROUGH AN ARRAY
		for(int i=0; i<secondWay.length; i++)
		{
			System.out.println("The #"+i+" element is "+secondWay[i]);
		}
		//For each int in secondWay
		for(String value: secondWay)
		{
			System.out.println("Element is "+value);
		}
		//primitive arrays are automatically populated with 0s
		//object arrays are not populated 
	}
	
	
	public static void main(String[] agrs)
	{
		ArrayMain sample = new ArrayMain();
	}

	public int diceRoll(int n)
	{
		int sum = 0;
		for(int i = 0; i<n; i++)
		{
			int dieRoll = (int) (Math.random()*6)+1;
			sum = sum + dieRoll;
		}
		return sum;
	}
}
	