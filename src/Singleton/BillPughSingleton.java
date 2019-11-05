package Singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class BillPughSingleton {
	private static final AtomicInteger INSTANCE_COUNT = new AtomicInteger();
    private static final AtomicInteger INVOKE_COUNT = new AtomicInteger();


	
	private BillPughSingleton() {
		System.out.println("new SingletonObject");
        INSTANCE_COUNT.getAndIncrement();
	}
	private static class SingletonHelpor{
		private static BillPughSingleton INSTANCE=new BillPughSingleton();	
	}
	
	public static BillPughSingleton getInstanceLazyInitializedSingleton() {
		INVOKE_COUNT.getAndIncrement();
		return SingletonHelpor.INSTANCE;
	}
	public static int getInstanceCount() {
        return INSTANCE_COUNT.get();
    }

    public static int getInvokeCount() {
        return INVOKE_COUNT.get();
    }

}
