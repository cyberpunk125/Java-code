package SerializationExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeserializationExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		B b=new B();
		FileOutputStream fos=new FileOutputStream("abc.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(b);
		
		FileInputStream fis=new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		B b1=(B) ois.readObject();
		System.out.println(b1.a+"    "+b1.b);
	}

}

class A {
	int a=20;
}
class B extends A implements Serializable{
	
	int b=10;	
	public B() {
		// TODO Auto-generated constructor stub
		b=8;
	}
}
