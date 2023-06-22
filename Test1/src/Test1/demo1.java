package Test1;

class demo2 extends Thread{

	@Override
	public void run() {
	for(int i=0;i<10;i++) {
		System.out.println(getId()+i);
		
	}	
	try {
		sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demo2 d1=new demo2();
		demo2 d2=new demo2();
		d1.start();
		d2.start();

	}

}
