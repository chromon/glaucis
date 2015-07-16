import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors; 

public class T10_ThreadPool implements Runnable {
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	public static void main(String [] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for(int i=0; i<10; i++) {
			pool.execute(new T10_ThreadPool());

		}
		pool.shutdown();
	}
}