package com.laibao.springaop.helloworldaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
public class MessageDecorator implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("Hello");
        Object result = invocation.proceed();
        System.out.print("!");
        return result;
    }
}
