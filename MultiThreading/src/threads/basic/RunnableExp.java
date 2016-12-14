package threads.basic;

class RunnableRunner implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("Hello "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class RunnableExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new RunnableRunner());
		Thread t2 = new Thread(new RunnableRunner());
		
		t1.start();
		t2.start();
	}

}
