package org.lining.javabase.design.factory.abstractFactory.impl;

import org.lining.javabase.design.factory.abstractFactory.api.AbstractWalkInterface;

public class KidWalk implements AbstractWalkInterface {
    private static KidWalk kidWalk = null;

    @Override
    public void walk() {
        System.out.println("a kid is walking");
    }

    private KidWalk(){

    }

    public static KidWalk getNewInstance(){
        if (kidWalk == null){
            kidWalk = new KidWalk();
        }
        return kidWalk;
    }
}
