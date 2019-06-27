package com.zhangcq.www.gadget.redis_queue;

/**
 * @Description: 消息
 * @author: zhangcq
 * @Time: 2019-6-26 17:16
 * @Version 1.0
 */
public class Message {
    private static final long serialVersionUID = -389326121047047723L;
    private String id;
    private String content;
    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}