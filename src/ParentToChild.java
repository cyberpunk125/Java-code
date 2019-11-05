class Parent{
	public void parentMethod() {
		System.out.println("eeeeeeeeeeeeeeeee");
	}
}

public class ParentToChild extends Parent{
	
	public void parentMethod() {
		System.out.println("llllllllllllllllllll");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent pr=new ParentToChild();
		
		
	}

}
