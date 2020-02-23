package com.example.liya.proxy.proxystatic;

import com.example.liya.proxy.Client;

public class StaticProxyTest {

    public static void main(String[] args) {
        Client client = new Client();
        StaticProxy staticProxy = new StaticProxy(client);
        staticProxy.buy();
    }
}
