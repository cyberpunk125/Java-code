package Multithreading;

public class VolatileExample extends Thread {
	static volatile boolean keepRunning=true;
	volatile int [] arr = new int[10];
	@Override
	public void run() {
		long count=0;
		while(keepRunning) {			
			count++;
		}
		System.out.println("thread terminated  "+count);
	}
	public static void main(String[] args) {
		VolatileExample ex=new VolatileExample();
		ex.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VolatileExample.keepRunning=false;
		System.out.println("thread end");
	}
}
