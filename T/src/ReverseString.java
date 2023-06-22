import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a[]=new char[100];
		int j=-1,k=0;
		char temp;
		System.out.print("Enter Any String : ");
		String str = sc.nextLine();
		String i1=str.trim();
		System.out.println(i1);
		
		//System.out.println(i1);
		for(int i=str.trim().length()-1;i>=0;i--) {
		if(str.charAt(i)=='@')
		{ j=i;}
		else{
			
			a[k]=str.charAt(i);
			k++;}

			//System.out.print(str.charAt(i));

		}
		
		if(j>=0)
		{
			System.out.println(j);
			temp=a[j];
			a[j]='@';
			a[j+1]=temp;}
	    
	    
	for(int i=0;i<str.trim().length();i++)
	{
	System.out.print(a[i]);	
	}
	}

		}


