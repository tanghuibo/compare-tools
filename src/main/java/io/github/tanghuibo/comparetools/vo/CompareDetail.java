package io.github.tanghuibo.comparetools.vo;

/**
 * @author tanghuibo
 * @date 2020/6/13上午12:07
 */
public class CompareDetail<PATH, DETAIL> {

    /**
     * 路径
     */
    private PATH path;

    /**
     * 明细
     */
    private DETAIL detail;

    public PATH getPath() {
        return path;
    }

    public void setPath(PATH path) {
        this.path = path;
    }

    public DETAIL getDetail() {
        return detail;
    }

    public void setDetail(DETAIL detail) {
        this.detail = detail;
    }
}
