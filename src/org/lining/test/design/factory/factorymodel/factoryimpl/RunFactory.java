package org.lining.test.design.factory.factorymodel.factoryimpl;

import org.lining.test.design.factory.factorymodel.api.MoveActionInterface;
import org.lining.test.design.factory.factorymodel.factory.MoveFactory;
import org.lining.test.design.factory.factorymodel.impl.RunActionImpl;

public class RunFactory implements MoveFactory{
    @Override
    public MoveActionInterface createMoveAction() throws Exception {
        return new RunActionImpl();
    }
}
