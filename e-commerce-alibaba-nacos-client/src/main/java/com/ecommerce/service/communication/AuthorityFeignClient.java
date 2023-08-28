package com.ecommerce.service.communication;

import com.ecommerce.service.communication.hystrix.AuthorityFeignClientFallback;
import com.ecommerce.service.communication.hystrix.AuthorityFeignClientFallbackFactory;
import com.ecommerce.vo.JwtToken;
import com.ecommerce.vo.UsernameAndPassword;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <h1>与 Authority 服务通信的 Feign Client 接口定义</h1>
 *  contextId 不指定内容 只有一个FeignClient 可以访问value 服务。
 *  value 要访问的服务ID (artifactId)
 * */
@FeignClient(
        contextId = "AuthorityFeignClient", value = "e-commerce-authority-center",
//        fallback = AuthorityFeignClientFallback.class
        fallbackFactory = AuthorityFeignClientFallbackFactory.class
)
public interface AuthorityFeignClient {

    /**
     * <h2>通过 OpenFeign 访问 Authority 获取 Token</h2>
     * */
    @RequestMapping(value = "/ecommerce-authority-center/authority/token",
            method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    JwtToken getTokenByFeign(@RequestBody UsernameAndPassword usernameAndPassword);
}
