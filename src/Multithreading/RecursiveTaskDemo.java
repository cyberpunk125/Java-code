package Multithreading;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool fjp = new ForkJoinPool(); 
		  
        double[] nums = new double[5000]; 
        for (int i = 0; i < nums.length; i++) { 
            nums[i] = (double)(((i % 2) == 0) ? i : -1); 
        } 
        Sum task = new Sum(nums, 0, nums.length); 
        double summation = fjp.invoke(task); 
        System.out.println("Summation " + summation);
        

	}

}

class Sum extends RecursiveTask<Double>{
	
	final int seqThreshold=500;
	double data[];
	int start,end;
	
	public Sum(double[] data,int start,int end) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.start=start;
		this.end=end;		
	}
	@Override
	protected Double compute() {
		double sum=0;
		if((end-start)<seqThreshold) {
			for(int i=start;i<end;i++) {
				sum=sum+data[i];
			}
		}
		else {
			int middle=(start+end)/2;
			Sum subtaskLeft=new Sum(data, start, middle);
			Sum subtaskRight=new Sum(data, middle, end);
			subtaskLeft.fork();
			subtaskRight.fork();
			sum+=subtaskLeft.join()+subtaskRight.join();
		}
		return sum;
	}
	
}
