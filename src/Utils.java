

public class Utils {
	public static void sleep(int number) {
		try {
			Thread.sleep(number);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
