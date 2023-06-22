import java.util.Scanner;

public class Test {  
  
	static String ronak (String str) {
		if (str.isEmpty()) {
			return str;
		}
		else {
			return ronak(str.substring(1))+str.charAt(0);
		}
	}
    public static void main(String[] args) {  
    	
    	
    	Scanner sc = new Scanner(System.in);
    	String sc1 = sc.next();
    	String a = ronak(sc1);
    	System.out.println(a);
    	
    	
    }
}