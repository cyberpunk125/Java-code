package Multithreading;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {
	static Queue<Integer> buffer=new LinkedList<>();
	public static void main(String args[]) {
		Producer producer=new Producer(buffer);
		Consumer consumer=new Consumer(buffer);
		producer.start();
		consumer.start();
	}
}

class Producer extends Thread{
	Queue<Integer> buffer;
	Producer(Queue<Integer> buffer) {
		this.buffer=buffer;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (buffer) {
				while(buffer.size()==10) {
					try {
						System.out.println("buffer is full so someone to consume");
						buffer.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int number=new Random().nextInt(1000);
				buffer.add(number);
				System.out.println("produce:: "+number);
				buffer.notify();
			}			
		}
	}
}

class Consumer extends Thread{
	Queue<Integer> buffer;
	public Consumer(Queue<Integer> buffer) {
		this.buffer=buffer;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (buffer) {
				while(buffer.isEmpty()) {
					try {
						System.out.println("buffer is empty so someone to produce");
						buffer.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int number=buffer.remove();
				System.out.println("consume:: "+number);
				buffer.notify();
			}
		}		
	}
}