package my.threadnew.FastThreadLocal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ThreadNew
 * @Description: TODO
 * @Date: 2021/5/18 20:51
 * @Version: 1.0
 */
public class InternalThreadLocalMap {
    // 唯一ID ,线程安全
    private static final AtomicInteger nextIndex = new AtomicInteger();
    // 存储数据
    private Object[] indexedVariables;
    // 数组长度
    private static final int INDEXED_VARIABLE_TABLE_INITIAL_SIZE = 32;
    // 默认存储值
    public static final Object UNSET = new Object();

    // 构造函数
    private InternalThreadLocalMap() {
        // 初始化数组
        indexedVariables = newIndexedVariabledTable();
    }

    private static Object[] newIndexedVariabledTable() {
        Object[] array = new Object[INDEXED_VARIABLE_TABLE_INITIAL_SIZE];
        Arrays.fill(array, UNSET);
        return array;
    }

    //得到下标
    public static int nextVariableIndex() {
        int index = nextIndex.getAndIncrement();
        return index;
    }

    // 插入
    public boolean setIndexedVariable(int index, Object value) {
        Object[] lookup = indexedVariables;
        if (index < lookup.length) {
            Object oldValue = lookup[index];
            lookup[index] = value;
            System.out.println(Thread.currentThread()+" "+(String)value);
            return oldValue == UNSET;
        } else {// 扩容处理
        }
        return true;
    }

    public Object indexedVariable(int index) {
        Object[] lookup = indexedVariables;
        return index < lookup.length ? lookup[index] : UNSET;
    }

    // get
    public static InternalThreadLocalMap get() {
        Thread thread = Thread.currentThread();
        if (thread instanceof FastThreadLocalThread) {
            return fastGet((FastThreadLocalThread) thread);
        }
        return null;
    }

    private static InternalThreadLocalMap fastGet(FastThreadLocalThread thread) {
        InternalThreadLocalMap threadLocalMap = thread.threadLocalMap();
        if (threadLocalMap == null) {
            thread.setThreadLocalMap(threadLocalMap = new InternalThreadLocalMap());
        }
        return threadLocalMap;
    }
}
