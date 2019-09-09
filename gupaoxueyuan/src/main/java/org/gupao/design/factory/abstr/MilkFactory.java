package org.gupao.design.factory.abstr;

import org.gupao.design.factory.Milk;
import org.gupao.design.factory.Telunsu;
import org.gupao.design.factory.YiLi;

public class MilkFactory extends AbstractFactory {
    @Override
    Milk getTelunsuMilk() {
        return new Telunsu();
    }

    @Override
    Milk getYiliMulk() {
        return new YiLi();
    }
}
