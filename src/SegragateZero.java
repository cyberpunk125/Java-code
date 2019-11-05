import java.util.stream.Stream;

public class SegragateZero {

	public static void main(String[] args) {
		int arr[]= {0,2,3,0,0,4,5,0};
		System.out.println(arr);
		segragateZero(arr);
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
	
	public  static void segragateZero(int a[]) {
		int size=a.length;
		int type0=0,type1=size-1;
		while(type0<type1) {
			if(a[type0]==0) {
				type0++;
			}else {
				int temp=a[type0];
				a[type0]=a[type1];
				a[type1]=temp;
				type1--;
			}
		}
	}

}
