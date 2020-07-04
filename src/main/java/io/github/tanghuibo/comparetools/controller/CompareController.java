package io.github.tanghuibo.comparetools.controller;

import io.github.tanghuibo.comparetools.param.CompareParam;
import io.github.tanghuibo.comparetools.service.ComparePropertiesService;
import io.github.tanghuibo.comparetools.vo.CompareResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author tanghuibo
 * @date 2020/6/12下午11:54
 */
@RestController
@RequestMapping("compare")
public class CompareController {
    @Resource
    ComparePropertiesService comparePropertiesService;

    @PostMapping("properties")
    private CompareResult<String, String> compareProperties(@RequestBody CompareParam<String> compareParam) throws IOException {
        return comparePropertiesService.compare(compareParam);
    }

    @PostMapping("propertiesKey")
    private CompareResult<String, String> comparePropertiesKey(@RequestBody CompareParam<String> compareParam) throws IOException {
        return comparePropertiesService.compareKey(compareParam);
    }
}
