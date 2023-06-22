package Test1;

import java.util.Arrays;
import java.util.Scanner;

public class arr {

	public static void main(String[] args) {
		
		int a[] = new int[5];
		int n;
		int count = 0;
		System.out.println("Enter the Elements of Array : ");
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<a.length; i++) {
			a[i]=sc.nextInt();
		}
		for(int i = 0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\nEnter the value which you find : ");
		n=sc.nextInt();
		for(int i = 0; i<a.length; i++) {
			if(a[i]==n) {
				count++;
			}	
		}
		if(count>0) {
			System.out.println("Element you enter is found in array");
		}
		else {
			System.out.println("Element you enter is not found in array");
		}
	}
}
