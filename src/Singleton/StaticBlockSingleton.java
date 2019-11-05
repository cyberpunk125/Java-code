package Singleton;

public class StaticBlockSingleton {

	private static StaticBlockSingleton INSTANCE;
	private StaticBlockSingleton() {}
	static {
		try {
			INSTANCE=new StaticBlockSingleton();
		}catch(Exception e) {
			throw new RuntimeException();
		}		
	}	
	public static StaticBlockSingleton getInstanceStaticBlockSingleton() {
		return INSTANCE;
	}

}
