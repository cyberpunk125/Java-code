package Multithreading;

public class DeadlockExample {
	 public static void main(String ...strings) {
		 Runnable r1=new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					synchronized (String.class) {
						System.out.println("string class");
						synchronized (Integer.class) {
							System.out.println("integer class");
						}
					}
				}
			};

		Runnable r2=new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					synchronized (Integer.class) {
						System.out.println("integer class");
						synchronized (String.class) {
							System.out.println("string class");
						}
					}
				}
			};
			new Thread(r2).start();
			new Thread(r1).start();
	 }
	
}
