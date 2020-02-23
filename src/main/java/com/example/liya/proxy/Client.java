package com.example.liya.proxy;

public class Client implements Shopping {
    @Override
    public void buy() {
        System.out.println("我想要购物");
    }
}
