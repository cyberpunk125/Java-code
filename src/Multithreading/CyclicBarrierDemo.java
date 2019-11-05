package Multithreading;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier=new CyclicBarrier(3);
		new Thread(new Person("Tarun",barrier)).start();
		new Thread(new Person("Varun",barrier)).start();
		new Thread(new Person("karun",barrier)).start();
		
		//System.out.println("all server are up and running");
	}

}

class Person implements Runnable{
	String name;
	CyclicBarrier barrier;
	public Person(String name,CyclicBarrier barrier) {
		this.name=name;
		this.barrier=barrier;
	}

	@Override
	public void run() {
		Utils.sleep(4000);
		System.out.println(name+" has reached.");
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" moving towards theatre.");
	}
	
}
