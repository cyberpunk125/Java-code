package LambdaExample;

import java.util.Arrays;
import java.util.List;

public class AsciiSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> charArray= Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
		int x=charArray.stream()
		.map(e->(int)(e))
		.reduce(0,Integer::sum);
		System.out.println(x);
		charArray.stream()
		.map(e->(int)(e))
		.forEach(e->System.out.print(" "+e));

	}

}
