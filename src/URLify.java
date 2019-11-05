
public class URLify {

	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();
		System.out.println("................"+String.valueOf(arr));
		int trueLength = findLastCharacter(arr) + 1;
		System.out.println("...............  "+trueLength);
		replaceSpaces(arr, trueLength);	
		System.out.println("................"+String.valueOf(arr));
	}
	
	private static int findLastCharacter(char[] ch) {
		for(int i=ch.length-1;i>=0;i--) {
			if(ch[i]!=' ') {
				return i;
			}
		}
		return -1;
	}  
	
	private static void replaceSpaces(char[] str,int length) {
		int index=str.length;
		System.out.println("index             "+index);
		for(int i=length-1;i>=0;i--) {
			if(str[i]==' ') {
				str[index-1]='0';
				str[index-2]='2';
				str[index-3]='%';
				index=index-3;
			}else {
				str[index-1]=str[i];
				index--;
			}
		}
		
	}

}
