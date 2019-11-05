package Multithreading;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer2 {
	static Queue<Integer> buffer=new LinkedList<>();
	static BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10);
	public static void main(String args[]) {
		Producer producer=new Producer(buffer);
		Consumer consumer=new Consumer(buffer);
		producer.start();
		consumer.start();
	}
}

class Producer2 extends Thread{
	Queue<Integer> buffer;
	BlockingQueue<Integer> queue;
	Producer2(Queue<Integer> buffer,BlockingQueue<Integer> queue) {
		this.buffer=buffer;
		this.queue=queue;
	}
	@Override
	public void run() {
		while(true) {
//			synchronized (buffer) {
//				while(buffer.size()==10) {
//					try {
//						System.out.println("buffer is full so someone to consume");
//						buffer.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				int number=new Random().nextInt(1000);
//				buffer.add(number);
//				System.out.println("produce:: "+number);
//				buffer.notify();
//			}	
			int number=new Random().nextInt(1000);
			System.out.println("produce:: "+number);
			try {
				queue.put(number);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer2 extends Thread{
	Queue<Integer> buffer;
	BlockingQueue<Integer> queue;
	Consumer2(Queue<Integer> buffer,BlockingQueue<Integer> queue) {
		this.buffer=buffer;
		this.queue=queue;
	}
	@Override
	public void run() {
		while(true) {
//			synchronized (buffer) {
//				while(buffer.isEmpty()) {
//					try {
//						System.out.println("buffer is empty so someone to produce");
//						buffer.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				int number=buffer.remove();
//				System.out.println("consume:: "+number);
//				buffer.notify();
//			}
			int number;
			try {
				number = queue.take();
				System.out.println("consume:: "+number);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
	}
}