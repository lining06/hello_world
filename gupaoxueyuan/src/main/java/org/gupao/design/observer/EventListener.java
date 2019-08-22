/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.design.observer;

import org.gupao.design.observer.core.Event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @version $Id: EventListener.java, v 0.1 2019-08-21 5:43 Exp $
 */
public class EventListener {

    //注册器
    protected Map<Enum, Event> eventMap = new HashMap<Enum, Event>();

    public void addListener(Enum enentType, Object target, Method callBack){
        eventMap.put(enentType, new Event(target, callBack));
    }

    protected void trigger(Enum call){
        if (!this.eventMap.containsKey(call)){
            return;
        }
        trigger(this.eventMap.get(call).setTrigger(call.toString()));
    }

    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try {
            event.getCallBack().invoke(event.getTarget(), event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}