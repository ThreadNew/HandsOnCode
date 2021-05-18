package my.threadnew.FastThreadLocal;

/**
 * @Author: ThreadNew
 * @Description: TODO
 * @Date: 2021/5/18 20:53
 * @Version: 1.0
 */
public class Things {
    private int ID;//唯一标识
    private final FastThreadLocal<String> threadLocal = new FastThreadLocal<String>() {
        @Override
        protected String initialValue() throws Exception {
            return "FastThreadLocal:Things";
        }
    };

    public Things(int id) {
        this.ID = id;
    }

    public void say() {
        System.out.println(Thread.currentThread() + " " + threadLocal.get());
    }

    public void set(String s) {
        threadLocal.set(s + " " + ID);
    }
}
