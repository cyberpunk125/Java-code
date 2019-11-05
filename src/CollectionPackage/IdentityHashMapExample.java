package CollectionPackage;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer I1=new Integer("10");
		Integer I2=new Integer("10");
		//IdentityHashMap<Integer, String> map=new IdentityHashMap<Integer, String>();
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		map.put(I1, "UT");
		map.put(I2, "AKG");
		System.out.println(map);
	}

}
