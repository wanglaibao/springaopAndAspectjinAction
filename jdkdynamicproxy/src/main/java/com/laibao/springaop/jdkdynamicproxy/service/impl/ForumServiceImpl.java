package com.laibao.springaop.jdkdynamicproxy.service.impl;

import com.laibao.springaop.jdkdynamicproxy.service.ForumService;

public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {
        System.out.println("删除Topic记录 topicId: "+topicId);
    }

    @Override
    public void removeForum(int forumId) {
        System.out.println("删除Forum记录 forumId: "+forumId);
    }
}
