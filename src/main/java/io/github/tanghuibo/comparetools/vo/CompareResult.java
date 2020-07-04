package io.github.tanghuibo.comparetools.vo;

import java.util.List;

/**
 * @author tanghuibo
 * @date 2020/6/13上午12:02
 */
public class CompareResult<PATH, DETAIL> {

    /**
     * 新增的
     */
    private List<CompareDetail<PATH, DETAIL>> addCompareDetailList;

    /**
     * 减少的
     */
    private List<CompareDetail<PATH, DETAIL>> removeCompareDetailList;

    /**
     * 差异项
     */
    private List<CompareDiffDetail<PATH, DETAIL>> compareDiffDetailList;

    public List<CompareDetail<PATH, DETAIL>> getAddCompareDetailList() {
        return addCompareDetailList;
    }

    public void setAddCompareDetailList(List<CompareDetail<PATH, DETAIL>> addCompareDetailList) {
        this.addCompareDetailList = addCompareDetailList;
    }

    public List<CompareDetail<PATH, DETAIL>> getRemoveCompareDetailList() {
        return removeCompareDetailList;
    }

    public void setRemoveCompareDetailList(List<CompareDetail<PATH, DETAIL>> removeCompareDetailList) {
        this.removeCompareDetailList = removeCompareDetailList;
    }

    public List<CompareDiffDetail<PATH, DETAIL>> getCompareDiffDetailList() {
        return compareDiffDetailList;
    }

    public void setCompareDiffDetailList(List<CompareDiffDetail<PATH, DETAIL>> compareDiffDetailList) {
        this.compareDiffDetailList = compareDiffDetailList;
    }
}
