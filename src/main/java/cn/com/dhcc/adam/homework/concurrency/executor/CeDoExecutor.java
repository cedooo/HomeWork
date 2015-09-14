package cn.com.dhcc.adam.homework.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CeDoExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable t = new Runnable(){

			@Override
			public void run() {
				System.out.println(" this is  a thread");
			}
			
		};
		ExecutorService executor =  Executors.newCachedThreadPool();  
		executor.execute(t);
		executor.shutdown();
		
	}

}
