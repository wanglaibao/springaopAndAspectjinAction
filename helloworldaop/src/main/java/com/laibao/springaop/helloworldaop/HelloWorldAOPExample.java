package com.laibao.springaop.helloworldaop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author laibao wang
 * @date 2018-01-21
 * @version 1.0
 */
public class HelloWorldAOPExample {

    public static void main(String[] args) {
        MessageWriter messageWriter = new MessageWriter();

        ProxyFactory proxyFactory = new ProxyFactory();
        MessageDecorator aroundAdvice = new MessageDecorator();
        proxyFactory.addAdvice(aroundAdvice);
        proxyFactory.setTarget(messageWriter);

        //获取代理对象
        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();

        messageWriter.writeMessage();
        System.out.println();

        proxy.writeMessage();
    }
}
