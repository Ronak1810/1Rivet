import java.util.Scanner;

public class Vovel {

	public static void main(String[] args) {
		char A;
		System.out.println("Enter character : ");
		Scanner sc = new Scanner(System.in);
		A = sc.next().charAt(0);
		
		if(A=='a' || A=='e' || A=='i' || A=='o' ||A=='u' || A=='A' || A=='E' || A=='I' || A=='O' ||A=='U') {
			System.out.print("vovel");
		}
		else {
			System.out.print("Consonant");
		}

	}

}
