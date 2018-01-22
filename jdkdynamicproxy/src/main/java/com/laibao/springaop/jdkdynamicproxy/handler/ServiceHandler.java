package com.laibao.springaop.jdkdynamicproxy.handler;

import com.laibao.springaop.jdkdynamicproxy.util.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceHandler implements InvocationHandler{

    private Object target;

    public ServiceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.beginMonitor(target.getClass().getName()+"."+method.getName());
        Object result = method.invoke(target,args);
        PerformanceMonitor.endMonitor();
        return result;
    }
}
