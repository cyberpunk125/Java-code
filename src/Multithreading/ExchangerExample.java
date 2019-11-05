package Multithreading;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerExample {
	public static void main(String[] args) {
		Exchanger<List<Integer>> exchanger=new Exchanger<List<Integer>>();
		new ExchangeConsumerThread(exchanger).start();
		new ExchangeProducerThread(exchanger).start();
	}
}
 class ExchangeConsumerThread extends Thread{
	 Exchanger<List<Integer>> exchanger;
	 List<Integer> integers=new ArrayList<Integer>();
	 public ExchangeConsumerThread(Exchanger<List<Integer>> exchanger) {
		// TODO Auto-generated constructor stub
		 this.exchanger=exchanger;
	}
	 @Override
	public void run() {
		
		try {
			System.out.println("Consumer Thread before exchnager:: "+integers);
			integers=exchanger.exchange(integers);
			Utils.sleep(2000);
			System.out.println("Consumer Thread after exchnager:: "+integers);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 }
 
 class ExchangeProducerThread extends Thread{
	 Exchanger<List<Integer>> exchanger;
	 List<Integer> integers=new ArrayList<Integer>();
	 public ExchangeProducerThread(Exchanger<List<Integer>> exchanger) {
		// TODO Auto-generated constructor stub
		 this.exchanger=exchanger;
	}
	 @Override
	public void run() {
		 for(int i=0;i<10;i++) {
			 integers.add(new Random().nextInt(1000));
		 }
		
		try {
			System.out.println("Producer Thread before exchnager:: "+integers);
			integers=exchanger.exchange(integers);
			System.out.println("Producer Thread after exchnager:: "+integers);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 }