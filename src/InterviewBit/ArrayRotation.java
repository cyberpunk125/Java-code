package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class ArrayRotation {
	
	static int[] arrayRotation1(int arr[],int k) {
		for(int i=0;i<k;i++) {
			int j=0;
			int temp=arr[0];
			for(;j<arr.length-1;j++) {
				arr[j]=arr[j+1];
			}
			arr[j]=temp;
		}
		return arr;
	}

	static int[] arrayRotation2(int arr[],int k) {
		ArrayList a=new ArrayList();
		Vector b=new Vector();
		
		Iterator itr=a.iterator();
		while(itr.hasNext()) {
			itr.remove();
		}
		for(int i=0;i<k;i++) {
			
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {1,2,3,4,5};
		arr=arrayRotation1(arr, 2%arr.length);
		Arrays.stream(arr)
		.forEach(e->System.out.print(e+" "));
	}

}
