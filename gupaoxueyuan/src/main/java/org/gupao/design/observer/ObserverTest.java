/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.design.observer;

import org.gupao.design.observer.core.Event;
import org.gupao.design.observer.core.SubjectEventEnum;

import java.lang.reflect.Method;

/**
 * @author sikuai.csy
 * @version $Id: ObserverTest.java, v 0.1 2019-08-21 6:09 PM sikuai.csy Exp $
 */
public class ObserverTest {

    public static void main(String[] args) {

        try{
            Observer observer = new Observer();
            Method printLog = Observer.class.getMethod("printLog", new Class<?>[]{Event.class});
            Subject subject = new Subject();

            subject.addListener(SubjectEventEnum.ADD, observer, printLog);
            subject.addListener(SubjectEventEnum.UPDATE, observer, printLog);
            subject.addListener(SubjectEventEnum.REMOVE, observer, printLog);
            subject.addListener(SubjectEventEnum.QUERY, observer, printLog);

            subject.add();
            subject.update();
        }catch (Exception e){

        }
    }
}