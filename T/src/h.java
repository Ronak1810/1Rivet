import java.util.Scanner;

public class h{
	public static void main(String[] args) {
		
		int count=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number : ");
		
		int a = sc.nextInt();
		
		for(int i = 1; i<=a; i++) {
			if(a % i == 0) {
				count++;
			}
		}
		if(count == 2) {
			System.out.println("NUmber is a prime");
		}
		else {
			System.out.println("NUmber is not a prime");
		}
	}
}