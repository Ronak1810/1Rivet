package Test1;

import java.util.Scanner;

public class AverageInArray {
	public static void main(String[] args) {
		int a[]= new int[5];
		int sum=0;
		int avg;
		System.out.print("Enter elements of Array : ");
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<a.length; i++) {
			a[i]=sc.nextInt();
		}
		for(int i = 0; i<a.length; i++) {	
			System.out.print(a[i]+" ");		
			sum = a[i]+sum;			
		}
		avg=sum/a.length;
		System.out.println("Average of the enter numbers is : "+ avg);
	}
}
