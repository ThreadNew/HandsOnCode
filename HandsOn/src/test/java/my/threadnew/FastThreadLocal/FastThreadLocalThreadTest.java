package my.threadnew.FastThreadLocal;

import org.junit.Test;

/**
 * @Author: ThreadNew
 * @Description: TODO
 * @Date: 2021/5/18 21:00
 * @Version: 1.0
 */
public class FastThreadLocalThreadTest {

    @Test
    public void run() throws InterruptedException {
        Things t1 = new Things(1);
        Things t2 = new Things(1);
        ThingsRun tr1 = new ThingsRun(t1);
        ThingsRun tr2 = new ThingsRun(t2);
        new FastThreadLocalThread(tr1).start();
        new FastThreadLocalThread(tr2).start();
        Thread.sleep(300000);

    }
}
