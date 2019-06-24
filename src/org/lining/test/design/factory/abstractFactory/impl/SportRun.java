package org.lining.test.design.factory.abstractFactory.impl;

import org.lining.test.design.factory.abstractFactory.api.AbstractRunInterface;

public class SportRun implements AbstractRunInterface {
    @Override
    public void runAndSmile() {
        System.out.println("a sport man is running, smile");
    }

    @Override
    public void runAndCry() {
        System.out.println("a sport man is running, cry");
    }
}
