import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ExternalizationDemo {
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Externalization ser=new Externalization(10, "amit");
		FileOutputStream fos=new FileOutputStream("kbc.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(ser);
		
		FileInputStream fis=new FileInputStream("kbc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		int k=ois.read();
		Externalization ser1=(Externalization) ois.readObject();
		System.out.println(ser1.num);
	}
	
	
}

class Externalization implements Externalizable {
	int num;
    final String name;
	public Externalization(int num,String name) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.name=name;
	}
	public Externalization() {
		super();
		num=0;
		name="abc";
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(num);
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		num=in.read();
	}
}
