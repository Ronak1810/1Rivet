package Test1;

import java.util.Scanner;

public class ASCII {

	public static void main(String[] args) {
		System.out.print("Enter any Character : ");
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		
		int a = ch;
		System.out.print("ASCII value of character " + ch + " is : " + a);
	}

}
