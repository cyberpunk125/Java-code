package ConcurrentCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import Multithreading.Utils;

public class CopyOnWriteArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOnWriteArrayList<String> l=new CopyOnWriteArrayList<String>();
		ArrayList<String> al=new ArrayList<String>();
		al.add("A");
		al.add("B");
		l.addIfAbsent("A");
		l.addIfAbsent("C");
		l.addAll(al);
		ArrayList<String> al2=new ArrayList<String>();
		al2.add("A");
		al2.add("E");
		l.addAllAbsent(al2);
		System.out.println(l);
		Iterator<String> itr=l.iterator();
		l.add("l");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println(l);
		Iterator<String> itr1=l.iterator();		
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}

	}

}
