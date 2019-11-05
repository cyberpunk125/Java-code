package Multithreading;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.stream.Stream;

public class ThreadGroupExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ThreadGroup tg=new ThreadGroup("MyThreadGroup");
//		Thread t=new Thread(tg,()->System.out.println("thread is running"));
//		new Thread(tg,()->System.out.println("thread is running")).start();
//		new Thread(tg,()->System.out.println("thread is running")).start();
//		new Thread(tg,()->System.out.println("thread is running")).start();
//		System.out.println(t);
//		t.start();
//		int count=tg.activeCount();
//		System.out.println(count);
		
//		ThreadGroup main=tg.getParent();
//		ThreadGroup system=main.getParent();
//		System.out.println(main);
//		System.out.println(system);
		
//		Thread[] threads=new Thread[system.activeCount()];
//		system.enumerate(threads);
//		for(Thread t1:threads) {
//			System.out.println("eeee       "+t1);
//		}
//		Stream.of(threads).forEach(System.out::println);
		
		MyThreadGroup group=new MyThreadGroup("Shaktimaan");
		Thread thread=new Thread(group,()->{
			throw new RuntimeException("failed while connecting");
		});
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t);
				System.out.println(e.getMessage());
			}
		});
		thread.start();
		
	}

}

class MyThreadGroup extends ThreadGroup{

	public MyThreadGroup(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println(t.getName());
		System.out.println(e.getMessage());
	}
	
}
