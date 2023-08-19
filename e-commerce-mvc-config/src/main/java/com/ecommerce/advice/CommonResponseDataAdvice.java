package com.ecommerce.advice;

import com.ecommerce.annotation.IgnoreResponseAdvice;
import com.ecommerce.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <h1>实现统一响应</h1>
 * */
@RestControllerAdvice(value = "com.ecommerce") //拦截返回内容
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> { //拦截返回内容  <Object>其它对象会报错

    /**
     * <h2>判断是否需要对响应进行处理</h2>
     * */
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {

        // 获取类上这个注解
        if (methodParameter.getDeclaringClass()
                .isAnnotationPresent(IgnoreResponseAdvice.class)) {
            // 不需要处理
            return false;
        }

        // 获取方法上这个注解
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            // 不需要处理
            return false;
        }

        // 响应需要包装 -> beforeBodyWrite();
        return true;
    }

    /**
     * <h2>
     *     返回客户端之前方法
     * </h2>
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        // 定义最终的返回对象
        CommonResponse<Object> response = new CommonResponse<>(0, "");

        if (null == o) {
            return response;
        } else if (o instanceof CommonResponse) {
            response = (CommonResponse<Object>) o;
        } else {
            response.setData(o);
        }

        return response;
    }
}
