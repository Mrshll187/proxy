package com.logicbig.example;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MyInterceptor<T> implements InvocationHandler {

    private T t;

    public MyInterceptor(T t) {
    	this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
    	System.out.println("before method call : " + method.getName());
        Object result = method.invoke(t, args);
        System.out.println("after method call : " + method.getName());
        return result;
    }

    @SuppressWarnings("unchecked")
	public static <T> T getProxy(T t, Class<? super T> interfaceType) {
        
    	MyInterceptor<T> handler = new MyInterceptor<T>(t);
        
    	return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class<?>[]{interfaceType}, handler);
    }
}