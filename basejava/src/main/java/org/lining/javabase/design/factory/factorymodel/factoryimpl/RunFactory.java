package org.lining.javabase.design.factory.factorymodel.factoryimpl;

import org.lining.javabase.design.factory.factorymodel.api.MoveActionInterface;
import org.lining.javabase.design.factory.factorymodel.factory.MoveFactory;
import org.lining.javabase.design.factory.factorymodel.impl.RunActionImpl;

public class RunFactory implements MoveFactory{
    @Override
    public MoveActionInterface createMoveAction() throws Exception {
        return new RunActionImpl();
    }
}
