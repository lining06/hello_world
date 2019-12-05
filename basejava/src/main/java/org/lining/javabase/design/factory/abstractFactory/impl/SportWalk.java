package org.lining.javabase.design.factory.abstractFactory.impl;

import org.lining.javabase.design.factory.abstractFactory.api.AbstractWalkInterface;

public class SportWalk implements AbstractWalkInterface {
    @Override
    public void walk() {
        System.out.println("a sport man is walking");
    }
}
