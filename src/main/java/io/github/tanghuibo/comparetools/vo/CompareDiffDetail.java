package io.github.tanghuibo.comparetools.vo;

/**
 * @author tanghuibo
 * @date 2020/6/13上午12:09
 */
public class CompareDiffDetail<PATH, DETAIL> {

    /**
     * 路径
     */
    private PATH path;

    /**
     * 旧数据
     */
    private DETAIL oldDetail;

    /**
     * 新数据
     */
    private DETAIL newDetail;

    public PATH getPath() {
        return path;
    }

    public void setPath(PATH path) {
        this.path = path;
    }

    public DETAIL getOldDetail() {
        return oldDetail;
    }

    public void setOldDetail(DETAIL oldDetail) {
        this.oldDetail = oldDetail;
    }

    public DETAIL getNewDetail() {
        return newDetail;
    }

    public void setNewDetail(DETAIL newDetail) {
        this.newDetail = newDetail;
    }
}
