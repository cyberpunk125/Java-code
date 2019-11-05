package Multithreading;

public class PrintEvenOddZero {

	public static void main(String[] args) {
		Printer1 print = new Printer1();
        Thread t1 = new Thread(new TaskEvenOdd1(print, 20, 1));
        Thread t2 = new Thread(new TaskEvenOdd1(print, 20, 2));
        Thread t3 = new Thread(new TaskEvenOdd1(print, 20, 0));
        t1.start();
        t2.start();
        t3.start();

	}

}

class TaskEvenOdd1 implements Runnable {

    private int max;
    private Printer1 print;
    private int isEvenNumber;

    TaskEvenOdd1(Printer1 print, int max, int isEvenNumber) {
        this.print = print;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {

        //System.out.println("Run method");
        int number = isEvenNumber == 2 ? 2 : 1;
        while (number <= max) {

            if (isEvenNumber%2==0) {
                //System.out.println("Even :"+ Thread.currentThread().getName());
                print.printEven(number);
                //number+=2;
            } else if(isEvenNumber%2!=0) {
                //System.out.println("Odd :"+ Thread.currentThread().getName());
                print.printOdd(number);
                // number+=2;
            } else {
            	print.printZero(0);
            }
            number += 2;
        }

    }

}

class Printer1{
	int sequence=0;;
	boolean isZero=false;
	synchronized void printEven(int number) {

        while (sequence==1 || sequence==0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" Even:" + number);
        sequence = 0;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while (sequence==2 || sequence==0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" Odd:" + number);
        sequence=2;
        notifyAll();
    }
    synchronized void printZero(int number) {
        while (sequence==2 || sequence==1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" Odd:" + number);
        sequence = 1;
        notifyAll();
    }
}
