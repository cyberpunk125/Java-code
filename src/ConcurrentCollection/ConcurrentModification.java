package ConcurrentCollection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModification {
	public static void main(String args[]) {
		List<String> list=Arrays.asList("A","B","C");
		Iterator<String>  itr=list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			list.add("D");
		}
	}

}
