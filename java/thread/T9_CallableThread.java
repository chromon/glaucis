import java.util.concurrent.Callable; 
import java.util.concurrent.FutureTask; 

public class T9_CallableThread implements Callable<Integer> {

	public Integer call() {
		int i = 0;
		for(; i<6; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		return i;
	}

	public static void main(String [] args) {
		try {
			T9_CallableThread ct = new T9_CallableThread();
			FutureTask<Integer> ft = new FutureTask<Integer>(ct);
			for(int i=0; i<5; i++) {
				System.out.println(Thread.currentThread().getName() + "-" + i);
				if(i == 2) {
					new Thread(ft).start();
					System.out.println(ft.isDone());
					Thread.sleep(1000);
				}
			}
			System.out.println("return:" + ft.get());
			System.out.println(ft.isDone());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}