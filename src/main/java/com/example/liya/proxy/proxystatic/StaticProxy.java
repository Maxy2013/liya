package com.example.liya.proxy.proxystatic;

import com.example.liya.proxy.Shopping;

public class StaticProxy implements Shopping {

    private Shopping shopping;

    public StaticProxy(Shopping shopping) {
        this.shopping = shopping;
    }

    @Override
    public void buy() {
        System.out.println("商品降价");
        shopping.buy();
    }
}
