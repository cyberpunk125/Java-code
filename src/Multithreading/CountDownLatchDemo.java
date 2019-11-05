package Multithreading;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch=new CountDownLatch(3);
		new Thread(new MyService("ValidationService",latch)).start();
		new Thread(new MyService("CacheService",latch)).start();
		new Thread(new MyService("SecurityService",latch)).start();
		latch.await();
		System.out.println("all server are up and running");
	}

}

class MyService implements Runnable{
	String name;
	CountDownLatch latch;
	public MyService(String name,CountDownLatch latch) {
		this.name=name;
		this.latch=latch;
	}

	@Override
	public void run() {
		Utils.sleep(4000);
		System.out.println(name+" server is up.");
		latch.countDown();
	}
	
}
