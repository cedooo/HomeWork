package javas.his.jdk8;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by cedo on 2016/9/20.
 * 锁： 内部锁 区块锁
 */
public class LockTest {
    private static Logger log = Logger.getLogger(LockTest.class);


    static class Person{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        synchronized  void bow(Person p){
            log.info(this.getName() + " bow to " + p.getName() + "[" + Thread.currentThread().getName() + "]");
            //wait 0.1second for all threads started
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.bowBack(this);
        }

        synchronized void bowBack(Person p){
            log.info(this.getName() + " bow back to " + p.getName()+ "[" + Thread.currentThread().getName() + "]");
        }
        Person(String name){
            this.name = name;
        }
        Person(){
            this.name = null;
        }
    }

    @Test(timeout = 5000)
    public void deadLockTest() throws InterruptedException{
        Person p1 = new Person("peter");
        Person p2 = new Person("pets");
        Thread t1 = new Thread(()->p1.bow(p2));
        Thread t2 = new Thread(()->p2.bow(p1));
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    /**
     * ??
     */
    static class syncPerson extends Person{
        @Override
        synchronized public void bow(Person p){
            log.info(this.getName() + " bow to " + p.getName() + "[" + Thread.currentThread().getName() + "]");
            //wait 0.1second for all threads started
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.bowBack(this);
        }
    }
}
