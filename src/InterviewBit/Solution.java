package InterviewBit;

import java.util.ArrayList;

public class Solution {
	
	public static void main(String args[]) {
		
	}
	
    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>() {
		
        } ;
        
        int n=A.size();
        int i, j, k, temp; 
        int g_c_d = gcd(n, B); 
        for (i = 0; i < g_c_d; i++) { 
            /* move i-th values of blocks */
            temp = A.get(i); 
            j = i; 
            while (true) { 
                k = j + B; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                A. set(j,A.get(k));
                j = k; 
            } 
            A.set(j, temp); 
        } 
        
        for (i = 0; i < A.size(); i++) {
            ret.add(A.get(i + B));
        }
        return ret;
    }
    public int gcd(int n,int d){
        if(d==0)return n;
        return gcd(d,n%d);
    }
}

