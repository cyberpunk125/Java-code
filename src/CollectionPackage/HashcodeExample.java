package CollectionPackage;

import java.util.HashMap;

class student{
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 2;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}	
}

public class HashcodeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<student,Integer> h=new HashMap<>();
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		h.put(new student(), 1);
		System.out.println(h.size());
		
		

	}

}
