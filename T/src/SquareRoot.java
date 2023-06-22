import java.util.Scanner;

public class SquareRoot {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number : ");
		int num = sc.nextInt();
		
		double temp;
		double sr = num/2;
		
		do {
			temp = sr;
			sr = (temp + (num/temp))/2;
		}
		while((temp-sr)!=0);
		System.out.println(sr);
	}

}