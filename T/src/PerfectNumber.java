import java.util.Scanner;

public class PerfectNumber {
	public static void main(String[] args) {
		
		int sum=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number : ");
		
		int a = sc.nextInt();
		
		for(int i = 1; i<a; i++) {
			if(a % i == 0) {
				sum = sum + i;
			}
		}
		if(a == sum) {
			System.out.println("Number is a perfect");
		}
		else {
			System.out.println("Number is not perfect");
		}
	}
}
