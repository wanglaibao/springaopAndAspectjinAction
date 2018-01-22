package com.laibao.springaop.jdkdynamicproxy.test;

import com.laibao.springaop.jdkdynamicproxy.GenericDynamicProxy;
import com.laibao.springaop.jdkdynamicproxy.handler.ServiceHandler;
import com.laibao.springaop.jdkdynamicproxy.service.ForumService;
import com.laibao.springaop.jdkdynamicproxy.service.impl.ForumServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ForumServiceTest {

    @Test
    public void testMethodOne() {
        List<String> fruits = List.of("Mangosteen", "Durian fruit", "Longan");
        assertThrows(UnsupportedOperationException.class, () -> {
            fruits.add("Mango");
            fruits.remove(1);
        });
        assertEquals(3, fruits.size());
        fruits.forEach(System.out::println);
    }

    @Test
    public void testDynamicProxyObject() {
        ForumService forumService = new ForumServiceImpl();   // target object

        ServiceHandler handler = new ServiceHandler(forumService);  // advice

        ForumService proxyObj = GenericDynamicProxy.getProxyObjectInstance(forumService.getClass().getClassLoader(),
                                                                            new Class[]{ForumService.class},
                                                                            handler);
        proxyObj.removeForum(100);
        proxyObj.removeTopic(1000);
    }
}
