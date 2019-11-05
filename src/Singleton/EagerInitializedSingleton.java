package Singleton;

public class EagerInitializedSingleton {

	private static final EagerInitializedSingleton INSTANCE=new EagerInitializedSingleton();
	private EagerInitializedSingleton() {}
	
	public static EagerInitializedSingleton getInstanceEagerInitializedSingleton() {
		return INSTANCE;
	}

}
