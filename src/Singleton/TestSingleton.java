package Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<Callable<BillPughSingleton>> invokers=new ArrayList<Callable<BillPughSingleton>>();
		for(int i=0;i<1000;i++) {
			invokers.add(BillPughSingleton::getInstanceLazyInitializedSingleton);
		}
		ExecutorService es=Executors.newFixedThreadPool(1000);
		es.invokeAll(invokers);
		es.shutdown();
		System.out.println("Number of Instances = " + BillPughSingleton.getInstanceCount());
	    System.out.println("Number of Invokes = " + BillPughSingleton.getInvokeCount());
	}  

}
