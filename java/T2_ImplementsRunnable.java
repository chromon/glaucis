/*
Ruanalbe接口对象target只能作为参数传递到Thread构造方法中，
所以多个线程可以共用一个Runnable对象，
因为都用同一个Runnable对象所以在Runnable实现类的实例变量也可以共享了。
所以Runable非常适合多个相同线程来处理同一份资源的情况。
*/
public class T2_ImplementsRunnable implements Runnable{
	private int i = 0;
	public void run() {
		for(; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	public static void main(String []args) {
		for(int i=0; i<20; i++) {
			System.out.println(Thread.currentThread().getName() + "----------" + i);
			if(i == 10) {
				System.out.println("============");
				T2_ImplementsRunnable r = new T2_ImplementsRunnable();
				new Thread(r).start();
				new Thread(r).start();
				System.out.println("============");
			}
		}
	}
}