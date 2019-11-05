package Multithreading;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class ExecutorsExample {
	public static void main(String[] args) {
		//ExecutorService service=Executors.newFixedThreadPool(5);
		//ExecutorService service=new ThreadPoolExecutor(10, 20,1,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(10) );
//		ExecutorService service=new ForkJoinPool(2);
		ExecutorService service=ForkJoinPool.commonPool();
		service.submit(()->{
			System.out.println("Runnable running");
			Utils.sleep(1000);
		});
		service.execute(()->{
			System.out.println("Runnable running");
			Utils.sleep(1000);
		});
		service.execute(()->{
			System.out.println("Runnable running");
			Utils.sleep(1000);
		});
		service.execute(()->{
			System.out.println("Runnable running");
			Utils.sleep(1000);
		});
		service.execute(()->{
			System.out.println("Runnable running");
			Utils.sleep(1000);
		});
		service.execute(()->{
			System.out.println("Runnable running");
			Utils.sleep(1000);
		});
		service.execute(()->{
			System.out.println("Runnable running");
			Utils.sleep(1000);
		});
		service.execute(()->{
			System.out.println("Runnable running");
			Utils.sleep(1000);
		});
		Future<Integer>future=service.submit(()->1);
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();
		System.out.println(service.shutdownNow());
		try {
			service.awaitTermination(1, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
