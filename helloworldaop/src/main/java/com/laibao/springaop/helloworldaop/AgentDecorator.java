package com.laibao.springaop.helloworldaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author laibao wang
 * @date 2018-01-21
 * @version 1.0
 */
public class AgentDecorator implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("james");
        Object result = invocation.proceed();
        System.out.print("!");
        return result;
    }
}
