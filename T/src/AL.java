import java.util.*;
public class AL {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		al.add("Ronak");
		al.add("jakey");
		al.add("Gracy");
		
//		System.out.println(al);
		
		
		
		Iterator itr = al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
