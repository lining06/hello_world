package org.lining.javabase.design.factory.factorymodel.impl;

import org.lining.javabase.design.factory.factorymodel.api.MoveActionInterface;

public class RunActionImpl implements MoveActionInterface{

    @Override
    public void move() throws Exception {
        System.out.println("m running");
    }

}
