package javas.his.jdk8;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by cedo on 2016/9/20.
 * 生产者消费者模式-oracle官方例子
 */
public class ProducerConsumerTest {
    private static final Logger log = Logger.getLogger(ProducerConsumerTest.class);

    static private class Drop{
        private String message;
        private boolean empty = true;
        synchronized  void put(String message){
            while(!empty){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.message = message;
            empty = false;
            notifyAll();
        }
        synchronized public String get(){
            while(empty){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = true;
            notifyAll();
            return message;
        }

    }
    static private  class Producer implements Runnable{
        private Drop drop;
        Producer(Drop drop){
            this.drop = drop;
        }

        @Override
        public void run() {
            java.util.List<String> messages = Arrays.asList(
                "message one","message two","message three","message four"
            );
            messages.forEach(message->{
                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                drop.put(message);
            });
            drop.put("DONE");

        }
    }
    static private class Consumer implements Runnable{
        private Drop drop;
        Consumer(Drop drop){
            this.drop = drop;
        }

        @Override
        public void run() {
            for(String message = drop.get();!"DONE".equals(message);message=drop.get()){
                log.info(" [MESSAGE] " + message);
                try {
                    Thread.sleep(new Random().nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("get message done!");
        }
    }

    @Test
    public void pcTest() throws InterruptedException{
        Drop drop = new Drop();
        Thread t1 = new Thread(new Producer(drop));
        Thread t2 = new Thread(new Consumer(drop));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

}
