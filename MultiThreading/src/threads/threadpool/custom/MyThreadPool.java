package threads.threadpool.custom;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
	private final int nThreads;
	private final WorkerPool[] threads;
	private final BlockingQueue<Runnable> queue;
	private boolean poolShutDownInitiated = false;
	
	public MyThreadPool(int nThreads){
		this.nThreads=nThreads;
		threads=new WorkerPool[nThreads];
		queue=new LinkedBlockingQueue<>();
		for(int i=0;i<nThreads;i++){			
			threads[i]=new WorkerPool();
			threads[i].setName("Thread-"+i);
			System.out.println(threads[i].getName()+" created in ThreadPool.");
			threads[i].start();
		}
	}
	
	public void execute(Runnable task) throws Exception{
		if(this.poolShutDownInitiated)
	           throw new Exception("ThreadPool has been shutDown, no further tasks can be added");
		synchronized (queue) {
			queue.add(task);
			queue.notify();	
		}		
	}
	
	public boolean isPoolShutDownInitiated() {
        return poolShutDownInitiated;
	}
	
	public synchronized void shutdown(){
	       this.poolShutDownInitiated = true;
	        System.out.println("ThreadPool SHUTDOWN initiated.");
	    }
	
	private class WorkerPool extends Thread {
		
		public void run(){
			Runnable task;
			try{
			while(true){
				synchronized(queue){
					while(queue.isEmpty()){
						try {
							queue.wait();
						} catch (InterruptedException e) {
							System.out.println("Waiting thread was interrupted");						}
					}
					task=queue.poll();						
				}
				task.run();
				if(isPoolShutDownInitiated()
                        &&  queue.size()==0){
                 this.interrupt();
                 /*
                  *  Interrupting basically sends a message to the thread
                  *  indicating it has been interrupted but it doesn't cause
                  *  a thread to stop immediately,
                  * 
                  *  if sleep is called, thread immediately throws
                  *  InterruptedException
                  */
                 Thread.sleep(1);  
          }   
			}
			}catch(Exception e){
				System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
			}

		}
	}
}
