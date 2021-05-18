package my.threadnew.FastThreadLocal;

/**
 * @Author: ThreadNew
 * @Description: TODO
 * @Date: 2021/5/18 20:57
 * @Version: 1.0
 */
public class ThingsRun implements Runnable{
    private Things things;
    public ThingsRun(Things things){
        this.things=things;
    }
    @Override
    public void run() {
        things.say();
        things.set(System.currentTimeMillis()+" ");
        things.say();
    }
}
