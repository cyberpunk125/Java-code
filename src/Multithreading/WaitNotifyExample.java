package Multithreading;

public class WaitNotifyExample {

	public static void main(String[] args) {
		Account1 acc=new Account1();
		Bank1 deposit=new Bank1(acc, "Deposit");
		Bank1 withdraw=new Bank1(acc,"Withdraw");
		deposit.start();
		withdraw.start();

	}

}

class Account1{
	int amount;
	boolean isDeposited=false;
}

class Bank1 extends Thread{
	String type;
	Account1 acc;
	public Bank1(Account1 acc,String type) {
		this.type=type;
		this.acc=acc;
		
	}
	@Override
	public void run() {
		while(true)
		if(type.equals("Deposit")){
			depositMoney();
		}else {
			withdrawMoney();
		}
		
	}
	
	private void depositMoney() {
		synchronized (acc) {
			while(acc.isDeposited) {
				try {
					acc.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			acc.amount+=2500;
			System.out.println("deposit money :: "+acc.amount);
			acc.isDeposited=true;
			acc.notifyAll();
			
		}
	}
	private void withdrawMoney() {
		synchronized (acc) {
			while(!acc.isDeposited) {
				try {
					acc.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			acc.amount-=2500;
			System.out.println("withdraw money :: "+acc.amount);
			acc.isDeposited=false;
			acc.notifyAll();
			
		}
	}
}
