/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.gupao.design.observer;

import org.gupao.design.observer.core.SubjectEventEnum;

/**
 * @author
 * @version $Id: Subject.java, v 0.1 2019-08-21 4:53 PM  Exp $
 */
public class Subject extends EventListener{

    public void add(){
        System.out.println("added");
        trigger(SubjectEventEnum.ADD);
    }

    public void update(){
        System.out.println("updated");
        trigger(SubjectEventEnum.UPDATE);
    }

    public void remove(){
        System.out.println("removed");
        trigger(SubjectEventEnum.REMOVE);
    }
}