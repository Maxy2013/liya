package com.example.liya.proxy.interceptor;

import com.example.liya.proxy.Client;
import com.example.liya.proxy.Shopping;

public class InterceptorTest {

    public static void main(String[] args) {
        InterceptorProxy interceptor = new InterceptorProxy(new MyInterceptor());
        Shopping shop = (Shopping) interceptor.bind(new Client());
        shop.buy();
    }
}
