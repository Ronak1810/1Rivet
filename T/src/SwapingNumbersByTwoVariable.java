import java.util.Scanner;

public class SwapingNumbersByTwoVariable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp;
		System.out.print("Enter the first number : ");
		int a = sc.nextInt();
		
		System.out.print("Enter the first number : ");
		int b = sc.nextInt();
		
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.print(a + " " + b );
}
}