import java.util.Date;
public class T5_SleepThread{
	public static void main(String [] args) {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + new Date());
			try{
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}