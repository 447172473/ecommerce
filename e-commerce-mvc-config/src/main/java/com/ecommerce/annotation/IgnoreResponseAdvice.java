package com.ecommerce.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>忽略统一响应注解定义</h1>
 */

@Target({ElementType.TYPE , ElementType.METHOD})  //ElementType 作用：注解（IgnoreResponse）可以表示在什么位置上，TYPE 代表类，METHOD 代表方法
@Retention(RetentionPolicy.RUNTIME) //标识注解保留到什么时候， RUNTIME 运行时
public @interface IgnoreResponseAdvice {



}
