package Test1;

import java.util.Scanner;

public class SwapNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp;
		System.out.print("Enter the first number : ");
		int a = sc.nextInt();
		
		System.out.print("Enter the first number : ");
		int b = sc.nextInt();
		
		temp = a;
		a = b;
		b = temp;
		System.out.print(a + " " + b );
	}

}
