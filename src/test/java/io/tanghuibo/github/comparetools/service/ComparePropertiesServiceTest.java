package io.tanghuibo.github.comparetools.service;

import com.alibaba.fastjson.JSON;
import io.tanghuibo.github.comparetools.param.CompareParam;
import io.tanghuibo.github.comparetools.service.impl.ComparePropertiesServiceImpl;
import io.tanghuibo.github.comparetools.vo.CompareResult;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author tanghuibo
 * @date 2020/6/14下午10:43
 */
class ComparePropertiesServiceTest {

    @Test
    public void testCompare() throws IOException {

        ComparePropertiesService comparePropertiesService = new ComparePropertiesServiceImpl();

        CompareParam<String> compareParam = new CompareParam<>();
        compareParam.setOldData("a=1\nb=2");
        compareParam.setNewData("a=2\nc=3");

        CompareResult<String, String> compareResult = comparePropertiesService.compare(compareParam);
        System.out.println(JSON.toJSONString(compareResult));

    }

}