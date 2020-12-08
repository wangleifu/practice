package com.study.practice.proxy;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/8 15:04
 */
public class Dog implements Animal {
    @Override
    public void cry() {
        System.out.println("汪汪汪~");
    }
}
