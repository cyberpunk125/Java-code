package ConcurrentCollection;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import Multithreading.Utils;

public class ConcurrentHashMapExample2 extends Thread{
	//static ConcurrentHashMap<Integer, String> chm=new ConcurrentHashMap<Integer, String>();
	static HashMap<Integer, String> chm=new HashMap<Integer, String>();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Utils.sleep(2000);
		System.out.println("Child Thread updating Map");
		chm.put(103, "C");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chm.put(101, "A");
		chm.put(102, "B");
		ConcurrentHashMapExample2 obj=new ConcurrentHashMapExample2();
		obj.start();
		Set<Integer> s=chm.keySet();
		java.util.Iterator<Integer> itr=s.iterator();
		while(itr.hasNext()) {
			Integer i1=itr.next();
			System.out.println("Main thread iterating and current entry is:: "+chm.get(i1));
			Utils.sleep(3000);
		}
		System.out.println(chm);
		
	}

}
