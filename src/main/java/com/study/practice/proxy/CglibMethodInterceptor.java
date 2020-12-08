package com.study.practice.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/8 15:49
 */
@Slf4j
public class CglibMethodInterceptor implements MethodInterceptor {

    public Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("cry".equals(method.getName())) {
            log.info("确保健康，有喊叫的能力~");
        }
        Object result = methodProxy.invokeSuper(obj, args);
        if ("cry".equals(method.getName())) {
            log.info("后处理~");
        }
        return result;
    }

    public Object getProxyObj() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


}
