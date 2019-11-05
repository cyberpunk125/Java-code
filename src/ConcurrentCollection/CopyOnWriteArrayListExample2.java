package ConcurrentCollection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import Multithreading.Utils;

public class CopyOnWriteArrayListExample2 extends Thread{

	static CopyOnWriteArrayList<String> cl=new CopyOnWriteArrayList<String>();
	@Override
	public void run() {		
		Utils.sleep(2000);
		System.out.println("Child Thread Updating List");
		cl.add("A");
	}
	public static void main(String[] args) {
		cl.add("B");
		cl.add("C");
		new CopyOnWriteArrayListExample2().start();
		Iterator<String> itr=cl.iterator();
		while(itr.hasNext()) {
			//itr.remove();
			System.out.println("Main Thread iterating list and object is:: "+itr.next());
			Utils.sleep(3000);
		}
		System.out.println(cl);
	}

}
