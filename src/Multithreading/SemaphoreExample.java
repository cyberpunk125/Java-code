package Multithreading;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startConnectionThreads();

	}
	
	private static void startConnectionThreads() {
		for(int i=0;i<100;i++) {
			new Thread(()->Connection.getConnection().connect()).start();
		}
	}

}

class Connection{
	static Semaphore semaphore=new Semaphore(10);
	static int connections=0;
	static Connection INSTANCE=new Connection();
	private Connection() {
		
	}
	public static Connection getConnection() {
		return INSTANCE;
	}
	public void connect() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			connections++;
			System.out.println("Current connections:: "+connections);
		}
		Utils.sleep(1000);
		synchronized (this) {
			connections--;			
		}
		System.out.println("Currently connections:: "+connections);
		semaphore.release();
	}
}
