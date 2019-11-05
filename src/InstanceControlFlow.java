
public class InstanceControlFlow {
	int i=10;
	{
		m1();
		System.out.println("First instance block");
	}
	public InstanceControlFlow() {
		System.out.println("Constructor");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InstanceControlFlow i=new InstanceControlFlow();
		InstanceControlFlow i2=new InstanceControlFlow();
		System.out.println("main");
	}
	public void m1() {
		System.out.println(j);
	}
	{
		System.out.println("Second instance block");
	}
	int j=20;
}
