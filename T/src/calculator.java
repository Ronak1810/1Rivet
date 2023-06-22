import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the first number : ");
		double n1 = sc.nextDouble();
		
		System.out.print("Enter the Second number : ");
		double n2 = sc.nextDouble();
		
		System.out.print("Enter the operator you want to perform(+,-,*,/) : ");
		char operator = sc.next().charAt(0);
		
		switch(operator) {
			case '+' :
				System.out.println(n1 + "+" + n2 + "=" + (n1+n2));
				break;
			case '-' :
				System.out.println(n1 + "-" + n2 + "=" + (n1-n2));
				break;
			case '*' :
				System.out.println(n1 + "*" + n2 + "=" + (n1*n2));
				break;
			case '/' :
				try {
					double d=n1/n2;
					System.out.println(d);	
				}
				catch(Exception e){
					System.out.println("exception");
				}
				
				break;
			default :
				System.out.println(" Please enter valid operator");
				break;
		}
	}
}