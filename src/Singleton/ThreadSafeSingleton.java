package Singleton;

public class ThreadSafeSingleton {

	private static ThreadSafeSingleton INSTANCE;
	private ThreadSafeSingleton() {}
	
	public static synchronized ThreadSafeSingleton getInstanceLazyInitializedSingleton() {
		if(INSTANCE==null) {
			INSTANCE=new ThreadSafeSingleton();
		}
		return INSTANCE;
	}
	
	public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
	    if(INSTANCE == null){
	        synchronized (ThreadSafeSingleton.class) {
	            if(INSTANCE == null){
	            	INSTANCE = new ThreadSafeSingleton();
	            }
	        }
	    }
	    return INSTANCE;
	}

}
