package com.limitingdemo.controller;


import com.limitingdemo.aspect.RedisLimit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fcj
 * @date 2022/7/21 0021
 */
@RestController
@RequestMapping("/limit/redis")
@Slf4j
public class limitingController {
    /**
     * 基于Redis AOP限流
     * 1.这里的参数也可以进行动态配置
     * 用mysql创建一个记录表，并把数据缓存到redis
     * 在切面中根据url获取相关配置
     * 2.如果是单体应用可以放到过滤器中进行，如果微服务应用可以放到网关进行统一处理
     */
    @GetMapping("/test")
    @RedisLimit(key = "redis-limit:test", permitsPerSecond = 2, expire = 1, msg = "当前排队人数较多，请稍后再试！")
    public String test() {
        log.info("限流成功。。。");
        return "ok";
    }
}
