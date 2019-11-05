
public class TestAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(chechUnique("abbbef"));

	}
	
	private static boolean chechUnique(String s) {
		int arr[]=new int[26];
		for(int i=0;i<s.length();i++) {
			int index=findIndex(s.charAt(i));
			System.out.println(index);
			if(arr[index]>0) {
				return false;
			}else {
				arr[index]++;
			}
		}
		return true; 
	}
	
	private static int findIndex(char c) {
		if(Character.isUpperCase(c)) {
			return c-65;
		}else {
			return c-97;
		}
	}

}
