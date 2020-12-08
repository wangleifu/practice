package com.study.practice.proxy;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/8 15:02
 */
public class Cat implements Animal {
    @Override
    public void cry() {
        System.out.println("喵喵喵~");
    }
}
