package org.lining.javabase.design.factory.abstractFactory.factoryimpl;

import org.lining.javabase.design.factory.abstractFactory.api.AbstractRunInterface;
import org.lining.javabase.design.factory.abstractFactory.api.AbstractWalkInterface;
import org.lining.javabase.design.factory.abstractFactory.factory.MoveFactory;
import org.lining.javabase.design.factory.abstractFactory.impl.KidRun;
import org.lining.javabase.design.factory.abstractFactory.impl.KidWalk;

public class KidFactory implements MoveFactory {
    @Override
    public AbstractRunInterface createRun() {
        return KidRun.getNewInstance();
    }

    @Override
    public AbstractWalkInterface createWalk() {
        return KidWalk.getNewInstance();
    }
}
