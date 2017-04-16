package threads.threadpool.custom;

public class MyThreadPoolTest {

	public static void main(String[] args) throws Exception {
		MyThreadPool threadPool=new MyThreadPool(7);
		for(int i=0;i<5;i++){
			Task task=new Task(i);
			threadPool.execute(task);
		}
		
		threadPool.shutdown();

	}

}
