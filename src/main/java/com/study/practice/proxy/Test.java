package com.study.practice.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/8 15:29
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
//        staticProxy();
        jdkProxy();
        cglibProxy();
    }


    private static void staticProxy() {
        log.info("静态代理~~");
        ProxyAnimal animal = new ProxyAnimal();

        // 学猫叫
        animal.setAnimal(new Cat());
        animal.cry();

        // 学狗叫
        animal.setAnimal(new Dog());
        animal.cry();
    }

    private static void jdkProxy() {
        log.info("jdk动态代理~~");
        LogInvocationHandler invocationHandler = new LogInvocationHandler();

        // 学猫叫
        invocationHandler.setTarget(new Cat());
        Animal cat = (Animal) invocationHandler.getProxyObj();
        cat.cry();
        /**
         * Cat cat = (Cat) invocationHandler.getProxyObj();
         * 上面这种方式会报错，因为jdk代理的接口，生成的代理类和接口的其他具体实现类平级，不能转换成具体实体类
         */


        // 学狗叫
        invocationHandler.setTarget(new Dog());
        Animal dog = (Animal) invocationHandler.getProxyObj();
        dog.cry();
    }

    private static void cglibProxy() {
        log.info("cglib动态代理~~");
        CglibMethodInterceptor methodInterceptor = new CglibMethodInterceptor();

        // 学猫叫
        methodInterceptor.setTarget(new Cat());
        Cat cat = (Cat) methodInterceptor.getProxyObj();
        cat.cry();

        // 学狗叫
        methodInterceptor.setTarget(new Dog());
        Dog dog = (Dog) methodInterceptor.getProxyObj();
        dog.cry();

        methodInterceptor.setTarget(new HelloConcrete());
        HelloConcrete helloConcrete = (HelloConcrete) methodInterceptor.getProxyObj();
        helloConcrete.say("你好~");
    }
}
