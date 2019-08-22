/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.design.observer.core;

import java.lang.reflect.Method;

/**
 * @author =
 * @version $Id: Event.java, v 0.1 2019-08-21 5:39 PM  Exp $
 */
public class Event {

    //事件
    private Object source;

    //目标对象
    private Object target;

    //方法
    private Method callBack;

    //触发
    private String trigger;

    private Long time;

    public Long getTime() {
        return time;
    }

    public Event setTime(Long time) {
        this.time = time;
        return this;
    }

    public Event(Object target, Method callBack) {
        this.target = target;
        this.callBack = callBack;
    }

    public Object getSource() {
        return source;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public Event setTarget(Object target) {
        this.target = target;
        return this;
    }

    public Method getCallBack() {
        return callBack;
    }

    public Event setCallBack(Method callBack) {
        this.callBack = callBack;
        return this;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callBack=" + callBack +
                ", trigger='" + trigger + '\'' +
                '}';
    }
}