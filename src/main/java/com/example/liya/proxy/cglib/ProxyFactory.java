package com.example.liya.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib 子类代理对象
 * 对Client对象在在内存中构建一个子类对象
 */
public class ProxyFactory implements MethodInterceptor {
    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象创建一个代理对象
     * @return
     */
    public Object getProxyInstance(){
        //1. 工具类
        Enhancer enhancer = new Enhancer();
        //2. 设置父类
        enhancer.setSuperclass(target.getClass());
        //3. 设置对调函数
        enhancer.setCallback(this);
        //4. 创建子类(代理对象)
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("降价");

        //执行目标对象的方法
        Object invoke = method.invoke(target, objects);

        System.out.println("买到了");
        return invoke;
    }
}
