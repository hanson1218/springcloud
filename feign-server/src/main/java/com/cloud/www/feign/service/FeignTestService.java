package com.cloud.www.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient注解必不可少，name后面跟的是生产者的服务名
// value --->指定调用哪个服务
// fallbackFactory--->熔断器的降级提示
@FeignClient(name = "producer")
public interface FeignTestService {
    @RequestMapping(value = "/feigntest", method = RequestMethod.GET)
    String test(@RequestParam("name") String param);
}
