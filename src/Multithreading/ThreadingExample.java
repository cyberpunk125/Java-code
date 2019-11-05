package Multithreading;
import java.util.Arrays;
import java.util.List;

public class ThreadingExample {
	public static void main(String args[]) throws InterruptedException {
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("child run is running");
			}
		};
//		 Thread t=new Thread(r,"Amit");
//		 System.out.println(t);
//		 t.start();
//		 boolean alive=t.isAlive();
//		 System.out.println(alive);
//		 t.join(100);
//		 Thread.currentThread().join();
//		 while(t.isAlive()) {
//			 try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		 }
//		 try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 t.start();
		
//		Thread thread = new Thread() {
//			@Override
//			public void run() {
//				System.out.println("thread run is running");
//			}
//		};
//		System.out.println(thread);
//		thread.start();
//		
//		
//		Runnable r=()->System.out.println("Child thread is running");
//		Thread t=new Thread(r);
//		
//		t.start();
//		System.out.println("main thread is running");
		
//		Bank b=new Bank();
//		System.out.println(b);
		
		new Thread(r).start();
		Thread daemon=new Thread(()-> {
			List<Integer> integers=Arrays.asList(1,2,3,4,5,6,7);
			for(int i:integers) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
		});
		daemon.setDaemon(true);
		daemon.start();	
		
		
	}

}

class Bank extends Thread{
	Bank(){
		super("amit");
	}
	@Override
	public void run() {
		System.out.println("Bank thread run is running");
	}
}
