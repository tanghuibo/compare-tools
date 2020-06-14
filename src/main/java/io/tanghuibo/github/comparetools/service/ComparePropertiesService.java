package io.tanghuibo.github.comparetools.service;

import io.tanghuibo.github.comparetools.param.CompareParam;
import io.tanghuibo.github.comparetools.vo.CompareResult;

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
}
