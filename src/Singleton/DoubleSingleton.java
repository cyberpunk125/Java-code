package Singleton;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public final class DoubleSingleton implements Cloneable,Serializable {
	private DoubleSingleton() {}
	private static AtomicInteger counter=new AtomicInteger(1);
	public static DoubleSingleton getInstance() {
		if(counter.getAndIncrement()%2==0)
			return EvenHelper.instance;
		else
			return OddHelper.instance;
	}
	
	private static class EvenHelper{
		static DoubleSingleton instance=new DoubleSingleton();
	}
	private static class OddHelper{
		static DoubleSingleton instance=new DoubleSingleton();
	}
}
