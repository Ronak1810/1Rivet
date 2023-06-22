package Test1;

import java.util.Scanner;

public class Fectorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int fact=1;
		
		System.out.print("Enter the number : ");
		int a = sc.nextInt();
		
		for(int i = 1; i<=a; i++) {
			fact = fact*i;
		}
		System.out.print("Factorial of given number is : " + fact);
	}

}
