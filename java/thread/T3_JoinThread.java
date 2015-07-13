public class T3_JoinThread implements Runnable{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	public static void main(String [] args) {
		T3_JoinThread tj = new T3_JoinThread();
		Thread t = new Thread(tj);
		t.start();
		for(int i=0; i<10; i++) {
			if(i == 3) {
				Thread t2 = new Thread(tj);
				t2.start();
				try{
					//main的线程中调用了t2线程的join方法  
					//让第二个线程执行完成后再执行main 
					t2.join();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}