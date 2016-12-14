package threads.synchronization;

public class SynchronizedExp {

	private int count=0;
	
	public synchronized void increment(){
		count++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronizedExp exp = new SynchronizedExp();
		exp.dowork();
	}
	
	public void dowork(){
		Thread t1 = new Thread(() -> {
			for(int i=0;i<10000;i++){
				//count++;
				increment();
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=0;i<10000;i++){
				//count++;
				increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("count="+count);
		
	}

}
