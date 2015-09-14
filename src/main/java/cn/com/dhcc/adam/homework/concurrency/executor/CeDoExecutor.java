package cn.com.dhcc.adam.homework.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CeDoExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CeDoExecutor cde = new CeDoExecutor();
		//cde.cached();
		cde.fixed();
		//cde.schedule();
		//cde.single();
	}

	public void cached(){
		Runnable t = new Runnable() {

			@Override
			public void run() {
				System.out.println(" this is  a thread");
			}

		};
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(t);
		executor.shutdown();
	}
	public void fixed(){
		int nThreads = Runtime.getRuntime().availableProcessors()*2;
		ExecutorService fixedThreadPool = Executors
				.newFixedThreadPool(nThreads);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println("fixedThreadPool: " + index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		try {  
		    Thread.sleep(50000);  
		 } catch (InterruptedException e) {  
		    e.printStackTrace();  
		   }  
		fixedThreadPool.shutdown();
	}
	public void schedule(){
		ScheduledExecutorService scheduledThreadPool = Executors
				.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("scheduledThreadPool delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);
		scheduledThreadPool.shutdown();
	}
	public void single(){
		ExecutorService singleThreadExecutor = Executors
				.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println("singleThreadExecutor:" + index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		singleThreadExecutor.shutdown();
	}
}
