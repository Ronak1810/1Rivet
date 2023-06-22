package Test1;

import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		
		int result=1;
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number : ");
		int a = sc.nextInt();
		
		System.out.print("Enter power : ");
		int b = sc.nextInt();
		
		for(int i = 1; i<=b; i++) {
			result = a*result;
		}
		System.out.print(result);
	}

}
