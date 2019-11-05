package Singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class DoubleTonLazy {
	private static AtomicInteger counter=new AtomicInteger();
	private enum SingleInstance{
		ODD,EVEN;
		private DoubleTonLazy instance=new DoubleTonLazy();
	}
	private DoubleTonLazy() {
		// TODO Auto-generated constructor stub
	}
	public static DoubleTonLazy getInstance() {
		return SingleInstance.values()[counter.getAndIncrement()%2].instance;
	}

}
