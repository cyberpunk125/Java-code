package Singleton;

public class LazyInitializedSingleton {

	private static LazyInitializedSingleton INSTANCE;
	private LazyInitializedSingleton() {}
	
	public static LazyInitializedSingleton getInstanceLazyInitializedSingleton() {
		if(INSTANCE==null) {
			INSTANCE=new LazyInitializedSingleton();
		}
		return INSTANCE;
	}

}
