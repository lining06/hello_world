/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.design.observer;

import org.gupao.design.observer.core.Event;

/**
 * @author sikuai.csy
 * @version $Id: Observer.java, v 0.1 2019-08-21 5:01 PM sikuai.csy Exp $
 */
public class Observer {

    public void printLog(Event event){
        System.out.println("logged");

        System.out.println(event.toString());
    }
}