package javas.his.jdk1_0;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.expression.ExpressionException;

/**
 * Created by cedo on 2016/9/19.
 */
public class ThreadRunnable {

    private static Logger log = Logger.getLogger(ThreadRunnable.class);
    @Test
    public void basicTest() throws Exception{
        Thread t1 = new Thread(new TestRunnable());
        Thread t2 = new TestThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }


    static class TestRunnable implements java.lang.Runnable{

        @Override
        public void run() {
            try{
                Thread.sleep(1000);
                log.info(Thread.currentThread().getName() + " done" );
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    static class TestThread extends Thread{
        @Override
        public void run(){
            try{
                Thread.sleep(1000);
                log.info(Thread.currentThread().getName() + " done" );
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
