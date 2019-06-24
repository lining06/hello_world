package org.lining.test.design.factory.abstractFactory.impl;

import org.lining.test.design.factory.abstractFactory.api.AbstractWalkInterface;

public class SportWalk implements AbstractWalkInterface {
    @Override
    public void walk() {
        System.out.println("a sport man is walking");
    }
}
