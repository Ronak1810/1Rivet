import java.util.Scanner;

abstract class A {
     int x,y;


    public abstract int sum();
    public abstract int sub();


}

 class b extends A{

    public int sum() {
        int sum = x + y;
        return sum;
    }
    public int sub() {
        int sub = x - y;
        return sub;
    }
    
}

public class Abstract{
    public static void main (String[] args) {
    	b obj1=new b();
    	Scanner scan=new Scanner(System.in);
    	obj1.x=scan.nextInt();
    	obj1.y=scan.nextInt();
    	int a=obj1.sum();
    	System.out.println("sum ="+a);
    	int b=obj1.sub();
    	System.out.println("sub ="+b);

    }

}