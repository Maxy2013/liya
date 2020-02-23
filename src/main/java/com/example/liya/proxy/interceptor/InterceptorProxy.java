package com.example.liya.proxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorProxy implements InvocationHandler {


    private Object target;

    private Interceptor interceptor;

    InterceptorProxy(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptor == null){
            method.invoke(target, args);
        }

        Object result = null;
        if(interceptor.before(proxy, target, method, args)){
            result = method.invoke(target, args);
        }else {
            interceptor.around(proxy, target, method, args);
        }
        interceptor.after(proxy, target, method, args);
        return result;
    }
}
