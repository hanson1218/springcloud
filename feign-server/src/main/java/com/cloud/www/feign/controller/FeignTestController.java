package com.cloud.www.feign.controller;

import com.cloud.www.feign.service.FeignTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignTestController {

    //@Resource注解可以换成@Autowired，但是会标红，不影响使用。使用@Resource不会标红。
    @Resource
    private FeignTestService feignTestService;


    @GetMapping("/test")
    public String test() {
        return feignTestService.test("feign").toString();
    }
}
