package Multithreading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
	public static void main(String[] args) {
		Account2 acc=new Account2();
		Bank2 bank=new Bank2(acc);		
		new Thread(bank).start();
		new Thread(bank).start();
		new Thread(bank).start();
		new Thread(bank).start();
	}
}
class Account2{
	int amount =10000;
}

class Bank2 implements Runnable{
	Lock lock=new ReentrantLock();
	Account2 acc;
	public Bank2(Account2 acc) {
		this.acc=acc;
	}
	
	@Override
	public  void run() {
    	lock.lock();
		//synchronized (Banks.class) {
		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			acc.amount-=2500;
			System.out.println(Thread.currentThread().getName()+" withdrawing 2500 from account :: "+acc.amount);
		//}	
//		if (lockAcquired) {
			lock.unlock();	
//		}	
		
	}
}
