/*
非守护进程结束，守护进程也会随之结束，但不是马上
*/
public class T4_DaemonThread implements Runnable{
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	public static void main(String [] args) {
		T4_DaemonThread dt = new T4_DaemonThread();
		Thread t = new Thread(dt);
		System.out.println("is main thread is daemon thread:" 
			+ Thread.currentThread().isDaemon());
		System.out.println("is t thread is daemon thread:" 
			+ t.isDaemon());
		t.setDaemon(true);
		System.out.println("is t thread is daemon thread now:"
			+ t.isDaemon());
		t.start();
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}