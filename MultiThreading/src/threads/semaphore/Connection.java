package threads.semaphore;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection instance = new Connection();
	private int connections=0;
	Semaphore sem=new Semaphore(10);
	
	private Connection(){
		
	}
	
	public static Connection getInstance(){
		return instance;
	}
	
	public void connect(){
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			doconnect();
		}finally{
			sem.release();
		}
	}
	
	public void doconnect(){

		synchronized(this){
			connections++;
			System.out.println("Current connections : "+connections);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this){
			connections--;			
		}
		
		
	}
}
