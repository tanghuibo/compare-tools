package io.tanghuibo.github.comparetools.controller;

import io.tanghuibo.github.comparetools.param.CompareParam;
import io.tanghuibo.github.comparetools.vo.CompareResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanghuibo
 * @date 2020/6/12下午11:54
 */
@RestController
@RequestMapping("compare")
public class CompareController {

    @PostMapping("properties")
    private CompareResult<String, String> compareProperties(@RequestBody CompareParam<String> compareParam) {
        return new CompareResult<>();
    }
}
