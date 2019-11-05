package Multithreading;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionExample {
	
	static ReentrantLock lock=new ReentrantLock();
	static Condition waitingForIOinput=lock.newCondition();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread(lock,waitingForIOinput).start();
		new IOThread(lock,waitingForIOinput).start();

	}

}

class MyThread extends Thread{
	Lock lock;
	Condition waitingForIOInput;
	public MyThread(Lock lock, Condition waitingForIOinput) {
		this.lock=lock;
		this.waitingForIOInput=waitingForIOinput;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {			
			lock.lock();
			try {
				System.out.println("Train "+i+" is waiting at outer");
				
				waitingForIOInput.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.unlock();
			System.out.println("train "+i+" started running towards platform");
			System.out.println("=============================================");					
			Utils.sleep(1000);
		}
	}
	
}

class IOThread extends Thread{
	Lock lock;
	Condition waitingForIOInput;
	public IOThread(Lock lock, Condition waitingForIOinput) {
		this.lock=lock;
		this.waitingForIOInput=waitingForIOinput;
	}
	
	@Override
	public void run() {
		while(true) {
			lock.lock();
			System.out.println("Train waiting at outer, please signal by pressing enter");
			new Scanner(System.in).nextLine();
			waitingForIOInput.signal();
			lock.unlock();
			Utils.sleep(1000);
		}		
	}
	
}
