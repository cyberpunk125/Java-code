import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.RepaintManager;

public class Solution {
	public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
		ArrayList<Integer> al=new ArrayList<Integer>();
       A.stream()
       .map(a->Math.abs(a))
       .map(a->A.get(a)>0?A.set(a,-A.get(a)):al.add(a));
       
       A.stream()
       .map(a->A.get(a)>0?al.add(a+1):0);
       return al; 
        
    }	
	
	public static void main(String args[]) {
		List<Integer> A=Arrays.asList( 7, 3, 4, 5, 5, 6, 2);
		A=repeatedNumber(A);
		A.stream()
		.forEach(System.out::println);
	}

}
