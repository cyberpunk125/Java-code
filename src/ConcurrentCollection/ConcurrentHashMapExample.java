package ConcurrentCollection;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConcurrentHashMap chm=new ConcurrentHashMap();
		chm.put(101, "Amit");
		chm.put(102, "Sumit");
		System.out.println(chm);
		chm.putIfAbsent(101, "Shiva");
		//chm.put(null, "Rohit");
		System.out.println(chm);
	}

}
