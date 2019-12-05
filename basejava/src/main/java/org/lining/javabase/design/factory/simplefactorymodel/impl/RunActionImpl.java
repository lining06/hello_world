package org.lining.javabase.design.factory.simplefactorymodel.impl;

import org.lining.javabase.design.factory.simplefactorymodel.api.MoveActionInterface;

public class RunActionImpl implements MoveActionInterface{

    @Override
    public void move() throws Exception {
        System.out.println("m running");
    }
}
