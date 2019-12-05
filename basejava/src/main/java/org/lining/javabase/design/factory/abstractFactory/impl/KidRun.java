package org.lining.javabase.design.factory.abstractFactory.impl;

import org.lining.javabase.design.factory.abstractFactory.api.AbstractRunInterface;

public class KidRun implements AbstractRunInterface {

    private static KidRun kidRun= null;
    @Override
    public void runAndSmile() {
        System.out.println("a kid is running, smile");
    }

    @Override
    public void runAndCry() {
        System.out.println("a kid is running, cry");
    }

    private KidRun(){

    }

    public static KidRun getNewInstance(){
        if (kidRun == null){
            kidRun = new KidRun();
        }
        return kidRun;
    }
}
