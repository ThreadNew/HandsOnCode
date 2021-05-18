package my.threadnew.FastThreadLocal;

/**
 * @Author: ThreadNew
 * @Description: TODO
 * @Date: 2021/5/18 20:50
 * @Version: 1.0
 */
public class FastThreadLocalThread extends Thread {
    private InternalThreadLocalMap threadLocalMap;

    public final InternalThreadLocalMap threadLocalMap() {
        return threadLocalMap;
    }

    public final void setThreadLocalMap(InternalThreadLocalMap threadLocalMap) {
        this.threadLocalMap = threadLocalMap;
    }
    public FastThreadLocalThread(Runnable target) {
        super(target);
    }
}