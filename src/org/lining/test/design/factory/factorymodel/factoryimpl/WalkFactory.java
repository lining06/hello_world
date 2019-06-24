package org.lining.test.design.factory.factorymodel.factoryimpl;

import org.lining.test.design.factory.factorymodel.api.MoveActionInterface;
import org.lining.test.design.factory.factorymodel.factory.MoveFactory;
import org.lining.test.design.factory.factorymodel.impl.WalkActionImpl;

public class WalkFactory implements MoveFactory {
    @Override
    public MoveActionInterface createMoveAction() throws Exception {
        return new WalkActionImpl();
    }
}
