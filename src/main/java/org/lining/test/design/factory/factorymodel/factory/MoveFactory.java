package org.lining.test.design.factory.factorymodel.factory;

import org.lining.test.design.factory.factorymodel.api.MoveActionInterface;

public interface MoveFactory {

    /**
     * 工厂方法模式中，要增加产品类时也要相应地增加工厂类，客户端的代码也增加了不少。工厂方法把简单工厂的内部逻辑判断转移到了客户端代码来进行。

     优点：工厂内低耦合。避免违反开闭原则。

     缺点: 是每增加一个产品类，就需要增加一个对应的工厂类，增加了额外的开发量。
     */
    MoveActionInterface createMoveAction() throws Exception;
}
