package Test1;

import java.util.HashSet;
import java.util.Scanner;

public class RepeatedChar{
	public static void main(String [] args){
		System.out.println("Enter any sentance : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		char ch[] = str.toCharArray();
		HashSet<Character> h1=new HashSet<>(); 
		int count = 0; 
		for (int i = 0; i<ch.length; i++){
			
			for (int j =i+1; j<ch.length; j++)
			{
				if(ch[i]==ch[j] && ch[i] !=' ')
				{
					h1.add(ch[j]);
					count++;
					//System.out.print(ch[j]);
			     }
			}
		}
		System.out.println(h1);
		
	}
}