package com.example.liya.proxy.cglib;

public class ProxyFactoryTest {

    public static void main(String[] args) {
        Client target = new Client();

        Client proxy = (Client) new ProxyFactory(target).getProxyInstance();
        proxy.buy();

        Tire tire = new Tire();

        Tire tireProxy = (Tire) new ProxyFactory(tire).getProxyInstance();
        tireProxy.change();
    }
}
