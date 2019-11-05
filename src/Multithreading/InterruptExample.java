package Multithreading;

public class InterruptExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadB tB=new ThreadB();
		ThreadA tA=new ThreadA(tB);
		tB.start();
		tA.start();
		

	}

}

class ThreadB extends Thread{
	@Override
	public void run() {
		System.out.println("Before sleeping");
		System.out.println(this.isInterrupted());
		System.out.println(Thread.interrupted());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ThreadB run is running");
	}
}

class ThreadA extends Thread{
	ThreadB threadB;
	ThreadA(ThreadB threadB){
		this.threadB=threadB;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadB.interrupt();
		System.out.println("ThreadA run is running");
		
	}
	
}
