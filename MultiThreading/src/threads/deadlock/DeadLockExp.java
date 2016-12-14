package threads.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner {
	private Account acct1=new Account();
	private Account acct2=new Account();
	
	private Lock lock1=new ReentrantLock();
	private Lock lock2=new ReentrantLock();
	
	private void acquireLock(Lock firstLock, Lock secondLock) throws InterruptedException{
		boolean gotFirstLock=false;
		boolean gotSecondLock=false;
		while(true){
			//Acquire locks
		try{
			gotFirstLock=firstLock.tryLock();
			gotSecondLock=secondLock.tryLock();
		}finally{
			if(gotFirstLock && gotSecondLock){
				return;
			}
			if(gotFirstLock){
				firstLock.unlock();
			}
			if(gotSecondLock){
				secondLock.unlock();
			}
		}
		//Lock not acquired
		Thread.sleep(1);
		}
	}
	
	public void firstThread() throws InterruptedException{
		Random ran = new Random();
		for(int i=0;i<10000;i++){
			acquireLock(lock1,lock2);

			try{
			Account.transfer(acct1,acct2,ran.nextInt(100));
			}finally{
				lock1.unlock();
				lock2.unlock();
			}
		}
		
	}
	
	public void secondThread() throws InterruptedException{
		Random ran = new Random();
		for(int i=0;i<10000;i++){
			acquireLock(lock2,lock1);
			try{
			Account.transfer(acct2,acct1,ran.nextInt(100));
			}finally{
				lock1.unlock();
				lock2.unlock();
			}
		}
		
	}
	
	public void finished(){
		System.out.println("Account 1 balance : "+acct1.getBalance());
		System.out.println("Account 2 balance : "+acct2.getBalance());
		System.out.println("Total balance : "+(acct1.getBalance()+acct2.getBalance()));
	}
}

public class DeadLockExp{
	public static void main(String[] args){
		Runner runner = new Runner();
		Thread t1=new Thread(()->{
			try {
				runner.firstThread();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2=new Thread(()->{
			try {
				runner.secondThread();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		runner.finished();
	}
	
}
