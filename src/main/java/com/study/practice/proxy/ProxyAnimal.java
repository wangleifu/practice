package com.study.practice.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/8 15:04
 */
@Slf4j
public class ProxyAnimal implements Animal {

    private Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void cry() {
        log.info("确保健康，有喊叫的能力~");
        animal.cry();
        log.info("后处理~");
    }
}
