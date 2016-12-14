/*Implements thread using Thread class*/
package threads.basic;

class Runner extends Thread{
	
	public void run(){
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

public class ThreadExp {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.start();
		
		Runner runner3 = new Runner();
		runner3.run();

	}

}
