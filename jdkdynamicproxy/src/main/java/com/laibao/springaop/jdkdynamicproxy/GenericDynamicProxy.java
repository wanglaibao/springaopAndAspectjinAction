package com.laibao.springaop.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class GenericDynamicProxy<T> {
    public static <T> T getProxyObjectInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler invocationHandler) {
        return (T) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
