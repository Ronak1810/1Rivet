package Test1;

import java.util.Scanner;

public class CountDigitsOfNo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		System.out.print("Enter the first number : ");
		int a = sc.nextInt();
		
		while(a>0) {
			a=a/10;
			count++;
		}
		System.out.print("Digits of the number is : " + count);

	}

}
