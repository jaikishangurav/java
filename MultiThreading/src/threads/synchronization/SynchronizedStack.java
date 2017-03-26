package threads.synchronization;

import java.util.Random;
import java.util.Stack;

public class SynchronizedStack {
	private Stack<Integer> stack;
	
	int maxSize=10;
	
	Object lock =new Object();
	
	public SynchronizedStack(){
		stack=new Stack<>();
	}
	
	public void push(int data) throws InterruptedException{
		synchronized(lock){
			if(stack.size()==maxSize){
				System.out.println("Waiting for data to be read from full stack");
				lock.wait();
			}
			System.out.println("Pushed "+data+" to the stack");
			stack.push(data);
			lock.notify();
		}
	}
	
	public Integer pop() throws InterruptedException{
		synchronized(lock){
			boolean popped=false;
			int data=-1;
			if(!stack.empty()){
				data=stack.pop();
				System.out.println("Popped "+data+" to the stack");
				lock.notify();
				popped=true;
			}else{
				System.out.println("Waiting for data to be pushed onto stack");
				lock.wait();
			}
			if(!popped){
				data=stack.pop();
				System.out.println("Popped "+data+" to the stack");
				lock.notify();
			}
			return data;
		}
	}
	
	public static void main(String[] args){
		SynchronizedStack stack=new SynchronizedStack();
		Random random=new Random();
		Thread reader=new Thread(()->{
			for(int i=0;i<50;i++)
			try {
				stack.pop();
				//System.out.println("Read "+i+"th data:"+stack.pop());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread writer=new Thread(()->{
			for(int i=0;i<50;i++){
				try {
					int data=random.nextInt(1000);
					stack.push(data);
					//System.out.println("Wrote+"+i+"th data:"+data+"to stack");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		reader.start();
		writer.start();
		
		try {
			reader.join();
			writer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
