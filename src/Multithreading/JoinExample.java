package Multithreading;

public class JoinExample extends Thread{
	
	public Thread predecessor;
	
	public JoinExample(Thread predec,String name) {
		// TODO Auto-generated constructor stub
		super(name);
		predecessor=predec;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+ " Started;");
		if(predecessor!=null) {
			try {
				predecessor.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+ " Finished;");
		
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JoinExample j1=new JoinExample(null,"Thread-1");
		JoinExample j2=new JoinExample(j1,"Thread-2");
		JoinExample j3=new JoinExample(j2,"Thread-3");
		j1.start();
		j2.start();
		j3.start();
	}

}
