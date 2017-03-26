package threads.synchronization;
class SynchronizedClass{
	public synchronized void methodA(){
		System.out.println("Current thread : "+Thread.currentThread().getName());
		System.out.println("Method A before sleep");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Method A after sleep");
	}
	
	public synchronized void methodB(){
		System.out.println("Current thread : "+Thread.currentThread().getName());
		System.out.println("Method B before sleep");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Method B after sleep");
	}
}
public class SynchronizedMethodExp {

	public static void main(String[] args) {
		SynchronizedClass obj=new SynchronizedClass();
		Thread t1=new Thread(()->obj.methodA(),"t1");
		Thread t2=new Thread(()->obj.methodB(),"t2");
		System.out.println("Starting thread");
		t1.start();
		System.out.println("t1 thread started");
		t2.start();
		System.out.println("t2 thread started");
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
