package io.github.tanghuibo.comparetools.service;

import io.github.tanghuibo.comparetools.param.CompareParam;
import io.github.tanghuibo.comparetools.vo.CompareResult;

import java.io.IOException;

/**
 * Properties 比较服务
 * @author tanghuibo
 * @date 2020/6/14下午9:55
 */
public interface ComparePropertiesService {

    /**
     * Properties 比较
     * @param compareParam
     * @return
     * @throws IOException
     */
    CompareResult<String, String> compare(CompareParam<String> compareParam) throws IOException;

    /**
     * 只比较key
     * @param compareParam
     * @return
     *  @throws IOException
     */
    CompareResult<String, String> compareKey(CompareParam<String> compareParam) throws IOException;
}
