package CollectionPackage;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.WeakHashMap;

import Multithreading.Utils;

public class WeakHashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WeakHashMap<Temp, String> map=new WeakHashMap<Temp, String>();
		HashMap<Temp, String> map=new HashMap<Temp, String>();
		Temp t=new Temp();
		map.put(t,"AKG");
		System.out.println(map);
		t=null;
		System.gc();
		Utils.sleep(4000);
		System.out.println(map);
	}

}
class Temp{
	@Override
	public String toString() {
		return "temp";
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}
}
