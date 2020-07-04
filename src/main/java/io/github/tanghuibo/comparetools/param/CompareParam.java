package io.github.tanghuibo.comparetools.param;

/**
 * @author tanghuibo
 * @date 2020/6/13上午12:13
 */
public class CompareParam<T> {

    /**
     * 旧数据
     */
    private T oldData;

    /**
     * 新数据
     */
    private T newData;

    public T getOldData() {
        return oldData;
    }

    public void setOldData(T oldData) {
        this.oldData = oldData;
    }

    public T getNewData() {
        return newData;
    }

    public void setNewData(T newData) {
        this.newData = newData;
    }
}
