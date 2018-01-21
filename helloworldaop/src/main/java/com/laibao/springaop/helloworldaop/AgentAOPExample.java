package com.laibao.springaop.helloworldaop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author laibao wang
 * @date 2018-01-21
 * @version 1.0
 */
public class AgentAOPExample {
    public static void main(String[] args) {
        Agent agent = new Agent();
        AgentDecorator agentDecorator = new AgentDecorator();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(agent);
        proxyFactory.addAdvice(agentDecorator);

        Agent agentProxy = (Agent) proxyFactory.getProxy();

        agent.speak();
        System.out.println();
        agentProxy.speak();

    }
}
