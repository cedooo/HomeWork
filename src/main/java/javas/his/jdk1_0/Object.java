package javas.his.jdk1_0;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by cedo on 2016/9/19.
 */
public class Object {

    private static Logger log = Logger.getLogger(Object.class);
    /*@BeforeClass
    public static void simpleConfigure(){
        org.apache.log4j.BasicConfigurator.configure();
        log.info("use simple log4j configure");
    }*/
    @Test(timeout = 1)
    public void arrayTest(){
        String[] arrays2 = {"sc","chen", "dong", "chengdu"};
        String[] ar = {"sc","chen", "dong", "chengdu"};
        log.info(ar.hashCode() + " "  + arrays2.hashCode() + " " + (arrays2==ar) + " " + ar.equals(arrays2));
        log.info("cedo".hashCode());

        java.lang.Object o = "cedo";
        log.info(o.hashCode());
    }

}
