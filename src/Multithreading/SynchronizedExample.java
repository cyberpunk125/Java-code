package Multithreading;

public class SynchronizedExample {

	public static void main(String[] args) {
		Account acc=new Account();
		Banks bank=new Banks(acc);
//		new Thread(bank).start();
//		new Thread(bank).start();
//		new Thread(bank).start();
//		new Thread(bank).start();
		
		new Thread(new Banks(acc)).start();
		new Thread(new Banks(acc)).start();
		new Thread(new Banks(acc)).start();
		new Thread(new Banks(acc)).start();
	}

}

class Account{
	int amount =10000;
}

class Banks implements Runnable{
	
	Account acc;
	public Banks(Account acc) {
		this.acc=acc;
	}
	
	@Override
	public  void run() {
		//System.out.println(this);
		synchronized (Banks.class) {
			acc.amount-=2500;
			System.out.println(Thread.currentThread().getName()+" withdrawing 2500 from account :: "+acc.amount);
		}		
	}
}
