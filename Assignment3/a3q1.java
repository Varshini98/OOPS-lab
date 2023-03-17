import java.util.*;
public class a3q1 implements Runnable{
	static int counter=0;
	static int N;
    public a3q1() {
    	
    }

    static void incrementCounter() {
        System.out.println(Thread.currentThread().getName() + ": "
                + counter);
        counter=counter+1;
    }

    @Override
    public void run() {
    	if(counter>=N) {
    		counter=0;
    	}
        while (counter < N) {
            incrementCounter();
        }
    }

    public static void main(String[] args) {
      
        Scanner sc= new Scanner(System.in);
        int n;
        System.out.println("Enter number of thread: ");
        n= sc.nextInt();
        System.out.println("Enter max count in each thread: ");
        N=sc.nextInt();
        a3q1 te = new a3q1();
        for(int i=0; i<n; ++i) {
        	Thread thread1 = new Thread(te);
        	thread1.start();
        }
    }
}
