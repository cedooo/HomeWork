package cn.com.dhcc.adam.homework.concurrency;

public class CeDoBasicThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long patience = 50*1000;
        long startTime = System.currentTimeMillis();

        Thread t = new Thread(new PrintBInfo());
        t.start();
        
        while(t.isAlive()){
        	try {
				t.join(1000);
				if (((System.currentTimeMillis() - startTime) > patience)
		                  && t.isAlive()) {
		                threadMessage("Tired of waiting!");
		                t.interrupt();
		                // Shouldn't be long now
		                // -- wait indefinitely
		                t.join();
		            }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
        }
	} 
	// Display a message, preceded by
    // the name of the current thread
    static void threadMessage(String message) {
        String threadName =
            Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                          threadName,
                          message);
    }
    /**
     * 打印信息线程
     * @author cedo
     *
     */
    static class PrintBInfo implements Runnable{

    	@Override
    	public void run() {
    		String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
                };
                try {
                    for (int i = 0;
                         i < importantInfo.length;
                         i++) {
                        // Pause for 2 seconds
                        Thread.sleep(2000);
                        // Print a message
                        threadMessage(importantInfo[i]);
                    }
                } catch (InterruptedException e) {
                    threadMessage("I wasn't done!");
                }
    	}
    	
    }

}