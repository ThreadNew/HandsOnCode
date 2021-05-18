package my.threadnew.FastThreadLocal;

/**
 * @Author: ThreadNew
 * @Description: TODO
 * @Date: 2021/5/18 20:50
 * @Version: 1.0
 */
public class FastThreadLocal<V> {
    // ID
    private final int index;

    public FastThreadLocal() {
        index = InternalThreadLocalMap.nextVariableIndex();
    }

    //set
    public final void set(V value) {
        if (value != InternalThreadLocalMap.UNSET) {
            InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.get();
            threadLocalMap.setIndexedVariable(index, value);
        }
    }

    //get
    public final V get() {
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.get();
        Object v = threadLocalMap.indexedVariable(index);
        if (v != InternalThreadLocalMap.UNSET) {
            return (V) v;
        }

        return initialize(threadLocalMap);
    }

    private V initialize(InternalThreadLocalMap threadLocalMap) {
        V v = null;
        try {
            v = initialValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadLocalMap.setIndexedVariable(index, v);
        return v;
    }

    protected V initialValue() throws Exception {
        return null;
    }
}
