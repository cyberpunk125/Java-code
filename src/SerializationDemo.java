import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Serialization ser=new Serialization(10, "amit");
		FileOutputStream fos=new FileOutputStream("abc.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(ser);
		
		FileInputStream fis=new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Serialization ser1=(Serialization) ois.readObject();
		System.out.println(ser1.name+"                   "+ser.num);
	}
	
	
}

class Serialization implements Serializable {
	int num;
	transient final String name;
	public Serialization(int num,String name) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.name=name;
	}
}
