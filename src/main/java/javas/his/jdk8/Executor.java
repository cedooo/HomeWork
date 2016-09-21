package javas.his.jdk8;

import org.apache.log4j.Logger;
import org.junit.Test;

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
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executor.execute(()->log.debug(Thread.currentThread().getName() + " start "));


        ((java.util.concurrent.Executor)((command) -> {
            Thread t = new Thread(command);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })).execute(()->log.debug(Thread.currentThread().getName() + " start "));


        java.util.concurrent.Executors.newSingleThreadExecutor().execute(()->log.info(Thread.currentThread().getName() + " start "));

    }
}
