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

	public DrawThread(Accout accout, double amount) {
		this.accout = accout;
		this.amount = amount;
	}

	public void run() {
		draw();
	}

	public synchronized void draw() {
		if(accout.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName() + "-" + accout.getName() + ":"
				+ "get" + amount + "$");
			accout.setBalance(accout.getBalance() - amount);
			System.out.println("balance:" + accout.getBalance());
		}else {
			System.out.println("fail-balance:" + accout.getBalance() + "$");
		}
	}
}

public class T7_Synchronized {
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
/*
2.1同步监视器的锁定什么时候释放
  A.当前线程的同步方法，同步块执行结束。当前线程释放同步监视器
  B.在同步方法，块中遇到break，return终止了该代码块，方法.释放
  C.在代码块，方法中出现Error，Exception
  D.执行同步时，程序执行了同步监视器对象的wait（）方法，则当前线程暂停，释放
2.2同步监视器的锁定在以下情况不会被释放
  A.执行同步时，程序调用Thread.sleep（），Thread.yield（）方法来暂停当前线程的执行，不会释放
  B.执行同步时，其他线程调用了该线程的suspend方法将该线程挂起，不会释放（但是尽量避免使用suspend和resume来控制线程,容易导致死锁）
*/