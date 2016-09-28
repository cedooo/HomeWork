package javas.his.jdk5;



/**
 * Created by cedo on 2016/9/19.
 *
 */
public class HighLevelConcurrency {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HighLevelConcurrency.class);

    @org.junit.Test
    public void exe() {

        java.util.concurrent.Executors.newScheduledThreadPool(10)
                .scheduleAtFixedRate(() -> log.info(new java.text.SimpleDateFormat("G YYYY-MM-dd HH:mm:ss,SS").format(new java.util.Date())), 1, 5, java.util.concurrent.TimeUnit.SECONDS);

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
