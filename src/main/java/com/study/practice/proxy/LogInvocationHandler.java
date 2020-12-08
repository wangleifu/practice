package com.study.practice.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/8 15:27
 */
@Slf4j
public class LogInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("cry".equals(method.getName())) {
            log.info("确保健康，有喊叫的能力~");
        }
        Object result = method.invoke(target, args);
        if ("cry".equals(method.getName())) {
            log.info("后处理~");
        }
        return result;
    }

    public Object getProxyObj () {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
