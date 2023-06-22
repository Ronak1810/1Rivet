import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		System. out.print("Enter Any Number : ");
		
		int r,s=0,c;
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		c=a;
		while(a>0) {
			r = a % 10;
			s = (s*10)+r;
			a = a / 10;
		}
		if(c==s) {
			System.out.print("Number is Palindrome");
		}
		else {
			System.out.print("Number is  not Palindrome");
		}
	}

}
