package org.lining.test.design.factory.factorymodel.impl;

import org.lining.test.design.factory.factorymodel.api.MoveActionInterface;

public class WalkActionImpl implements MoveActionInterface{

    @Override
    public void move() throws Exception {
        System.out.println("m walking");
    }
}
