package Multithreading;
import java.util.Date;
import java.util.UUID;

public class ThreadLocalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ThreadLocal<Integer> integer=new ThreadLocal<Integer>() {
//			@Override
//			public Integer get() {
//				// TODO Auto-generated method stub
//				return 2;
//			}
//		};
//		System.out.println(integer.get());
//		integer.set(1);
//		System.out.println(integer.get());
		
		Runnable r=new ThreadLocalExampleInner();
				
		new Thread(r).start();
		new Thread(r).start();
	}

}

class ThreadLocalExampleInner implements Runnable{
//	UUID uuid=UUID.randomUUID();
//	Date date=new Date();
	ThreadLocal<UUID> uuid=ThreadLocal.withInitial(UUID::randomUUID);
	
	ThreadLocal<Date> date=ThreadLocal.withInitial(Date::new);
//	UUID uuid;
//	Date date;
	
	@Override
	public void run() {
//		UUID uuid=UUID.randomUUID();	
//		Date date=new Date();
//		uuid=UUID.randomUUID();
//		date=new Date();
		System.out.println(uuid.get()+"     "+date.get());
		
	}
}
