package io.tanghuibo.github.comparetools.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanghuibo
 * @date 2020/6/14下午10:30
 */
public class CompareResultBuilder<P, D> {

    List<CompareDetail<P, D>> addCompareDetailList;
    List<CompareDetail<P, D>> removeCompareDetailList;
    List<CompareDiffDetail<P, D>> compareDiffDetailList;

    public CompareResultBuilder() {
       addCompareDetailList = new ArrayList<>();
        removeCompareDetailList = new ArrayList<>();
        compareDiffDetailList = new ArrayList<>();
    }

    public void insertAdd(P p, D d) {
        CompareDetail<P, D> compareDetail = new CompareDetail<>();
        compareDetail.setPath(p);
        compareDetail.setDetail(d);
        addCompareDetailList.add(compareDetail);
    }

    public void insertRemove(P p, D d) {
        CompareDetail<P, D> compareDetail = new CompareDetail<>();
        compareDetail.setPath(p);
        compareDetail.setDetail(d);
        removeCompareDetailList.add(compareDetail);
    }

    public void insertDiff(P p, D oldD, D newD) {
        CompareDiffDetail<P, D> compareDiffDetail = new CompareDiffDetail<>();
        compareDiffDetail.setPath(p);
        compareDiffDetail.setOldDetail(oldD);
        compareDiffDetail.setNewDetail(newD);
        compareDiffDetailList.add(compareDiffDetail);
    }

    public CompareResult<P, D> build() {
        CompareResult<P, D> compareResult = new CompareResult<>();
        compareResult.setAddCompareDetailList(addCompareDetailList);
        compareResult.setRemoveCompareDetailList(removeCompareDetailList);
        compareResult.setCompareDiffDetailList(compareDiffDetailList);
        return compareResult;
    }

}
