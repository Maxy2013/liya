package com.example.liya.proxy.proxydynamic;

import com.example.liya.proxy.Client;
import com.example.liya.proxy.Shopping;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        Shopping client = new Client();
        DynamicProxy dynamicProxy = new DynamicProxy(client);

        //方式 1
        Shopping shop = (Shopping) Proxy.newProxyInstance(Shopping.class.getClassLoader(), new Class[]{Shopping.class}, dynamicProxy);
        shop.buy();

        //方式 2
        Shopping bind = (Shopping) dynamicProxy.bind(client);
        bind.buy();
    }
}
