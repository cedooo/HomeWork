package javas.his.jdk8;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by cedo on 2016/9/21.
 * 多线程执行
 */
public class Executor {

    static private Logger log = Logger.getLogger(Executor.class);

    /*public static void main(String[] args){
        ( (java.util.concurrent.Executor)((command) -> {
            new Thread(command).start();
        }) ).execute(()->log.debug(Thread.currentThread().getName() + " start "));
    }*/

    @Test
    public void runWithExecutor(){
        java.util.concurrent.Executor executor = (command) -> {
            Thread t = new Thread(command);
            t.start();
        };
        executor.execute(()->log.debug(Thread.currentThread().getName() + " start "));


        ((java.util.concurrent.Executor)
                command -> new Thread(command).start()
        ).execute(()->log.debug(Thread.currentThread().getName() + " start "));



        java.util.concurrent.Executors.newSingleThreadExecutor().execute(()->log.info(Thread.currentThread().getName() + " start "));



        Runnable r1 = ()->log.info(Thread.currentThread().getName());
        Runnable r2 = ()->log.info(Thread.currentThread().getName());

        java.util.concurrent.ScheduledExecutorService threadPool = java.util.concurrent.Executors.newScheduledThreadPool(10);
        threadPool.scheduleAtFixedRate(r1, 3, 3, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(r2, 2, 4, TimeUnit.SECONDS);

        try {
            Thread.sleep(100*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
