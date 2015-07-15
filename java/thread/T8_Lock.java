import java.util.concurrent.locks.ReentrantLock;

class Accout {
	private String id;
	private String name;
	private double balance;

	public Accout(String id, double balance, String name) {
		this.id = id;
		this.balance = balance;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() { 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override  
	public int hashCode() {  
		return id.hashCode();  
	}  
	
	@Override  
	public boolean equals(Object obj) {  
		if(obj!=null && obj.getClass() == Accout.class){  
			Accout target = (Accout)obj;  
			return target.getId().equals(id);  
		}  
		return false;  
	}
}

class DrawThread implements Runnable {

	private Accout accout;
	private double amount;
	private final ReentrantLock relock = new ReentrantLock();

	public DrawThread(Accout accout, double amount) {
		this.accout = accout;
		this.amount = amount;
	}

	public void run() {
		draw();
	}

	public void draw() {
		relock.lock();
		try {
			if(accout.getBalance() >= amount) {
				System.out.println(Thread.currentThread().getName() + "-" + accout.getName() + ":"
					+ "get" + amount + "$");
				accout.setBalance(accout.getBalance() - amount);
				System.out.println("balance:" + accout.getBalance());
			}else {
				System.out.println("fail-balance:" + accout.getBalance() + "$");
			}
		}finally {
			relock.unlock();
		}
	}
}

public class T8_Lock {
	public static void main(String[] args) {
		Accout a = new Accout("1", 1000, "Ellery");
		DrawThread dt = new DrawThread(a, 600);
		Thread t1 = new Thread(dt);
		Thread t2 = new Thread(dt);
		Thread t3 = new Thread(dt);
		Thread t4 = new Thread(dt);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
