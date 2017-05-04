package threads.threadpool.custom;

import java.util.Scanner;

public class MyThreadPoolTest {

	public static void main(String[] args) throws Exception {
		Scanner sr=new Scanner(System.in);
		System.out.println("Enter number of threads in thread pool:");
		int nThreads=sr.nextInt();
		MyThreadPool threadPool=new MyThreadPool(nThreads);
		System.out.println("Enter number of tasks to execute:");
		int nTasks=sr.nextInt();
		for(int i=0;i<nTasks;i++){
			Task task=new Task(i);
			threadPool.execute(task);
		}
		
		threadPool.shutdown();

	}

}
