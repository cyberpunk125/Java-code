package InterviewBit;

import java.util.Arrays;

public class PrintPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sieveOfErasto(18);
		
	}
	static void sieveOfErasto(int n) {
		boolean[] isPrime=new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0]=isPrime[1]=false;
		for(int i=2;i<=n;i++) {
			if(isPrime[i]) {
				for(int j=i*2;j<=n;j+=i) {
					isPrime[j]=false;
				}
			}
		}
		for(int i=0;i<=n;i++) {
			if(isPrime[i])
			System.out.println(i);
		}
	}

}
