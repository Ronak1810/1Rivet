package Test1;

import java.util.Scanner;

public class Tax {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		float sallary=1;
		System.out.print("Enter the Sallary amount : ");
		int a = sc.nextInt();
		
		if(a>=100000) {
			sallary = a*0.2f;
			System.out.print("Tex of sallary " + a + " is " + sallary);
		}
		else if(a>=10000) {
			sallary = a*0.10f;
			System.out.print("Tax of sallary " + a + "is " + sallary);
		}
		else {
			System.out.print("No tax for this sallary.");
		}
	}
}
