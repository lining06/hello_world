package org.lining.javabase.design.factory.abstractFactory.factoryimpl;

import org.lining.javabase.design.factory.abstractFactory.api.AbstractRunInterface;
import org.lining.javabase.design.factory.abstractFactory.api.AbstractWalkInterface;
import org.lining.javabase.design.factory.abstractFactory.factory.MoveFactory;
import org.lining.javabase.design.factory.abstractFactory.impl.SportRun;
import org.lining.javabase.design.factory.abstractFactory.impl.SportWalk;

public class SportFactory implements MoveFactory {
    @Override
    public AbstractRunInterface createRun() {
        return new SportRun();
    }

    @Override
    public AbstractWalkInterface createWalk() {
        return new SportWalk();
    }
}
