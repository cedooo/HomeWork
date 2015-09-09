package cn.com.dhcc.adam.homework.concurrency;

import java.util.Random;

public class GuardedBlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new GuardedBlock().guardedJoy();
		new GuardedBlock().test();
	}
	/**
	 * 调用方法必须获得该对象的对象锁
	 */
	public synchronized void guardedJoy() {
		boolean joy = false;
	    // This guard only loops once for each special event, which may not
	    // be the event we're waiting for.
	    while(!joy) {
	        try {
	            wait();
	        } catch (InterruptedException e) {}
	    }
	    System.out.println("Joy and efficiency have been achieved!");
	}
	/**
	 * 测试生产者-消费者
	 */
	public void test(){
		Drop drop = new Drop();
		new Thread(new Producer(drop)).start();
		new Thread(new Customer(drop)).start();
	}

}

class Producer implements Runnable{
	private Drop drop;
	public Producer(Drop drop){
		this.drop = drop;
	}
	@Override
	public void run() {
		String importantInfo[] = {
	            "Mares eat oats",
	            "Does eat oats",
	            "Little lambs eat ivy",
	            "A kid will eat ivy too"
	        };
		Random random = new Random();
		for (int i = 0; i < importantInfo.length; i++) {
			drop.put(importantInfo[i]);            
			System.out.format("MESSAGE PUT MESG: %s%n", importantInfo[i]);
			try{
				Thread.sleep(random.nextInt(5000));
			}catch(InterruptedException	e){
				
			}
		}
		drop.put("DONE");
	}
	
}
class Customer implements Runnable{

	private Drop drop;
	public Customer(Drop drop){
		this.drop = drop;
	}
	@Override
	public void run() {
		Random random = new Random();
        for (String message = drop.take();
             ! message.equals("DONE");
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
	}
	
}
class Drop{
	
	private boolean empty = true;
	private String message = null;
	
	public synchronized void put(String message){
		while(!empty){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.message = message;
		this.empty = false;
		this.notifyAll();
	}
	
	public synchronized String take(){
		while(empty){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.empty = true;
		this.notifyAll();
		return message;
	}

}